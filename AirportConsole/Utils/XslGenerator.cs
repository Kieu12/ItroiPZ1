using System.Text;

namespace AirportConsole.Utils;

public static class XslGenerator
{
    public static void GenerateXslSchema(Type type, string path)
    {
        //write xsl schema from type with reflection and add all fields
        //to the xsl schema
        var styles = @"<style>
                    body {
                    font-family: Arial, sans-serif;
                    line-height: 1.6;
                    margin: 20px;
                    }
                    h1 {
                    color: #333;
                    }
                    .section {
                    margin-bottom: 20px;
                    }
                    .temp-c {
                    border: 1px solid #ccc;
                    padding: 10px;
                    margin-bottom: 10px;
                    margin-inline: 10px;
                    }
                    
                    .section-flex {
                    display: flex;
                    }
                </style>";

        var sb = new StringBuilder();
        sb.AppendLine("<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">");
        sb.AppendLine("<xsl:template match=\"/\">");
        sb.AppendLine("<html>");
        sb.AppendLine("<head>");
        sb.AppendLine($"<h1>{type.Name}</h1>");
        sb.AppendLine($"<title>{type.Name} Details</title>");
        sb.AppendLine(styles);
        sb.AppendLine("</head>");
        sb.AppendLine("<body>");

        sb.AppendLine(GetClassInClass(type, type.Name));

        sb.AppendLine(GetListInClass(type, type.Name));

        sb.AppendLine("</body>");
        sb.AppendLine("</html>");
        sb.AppendLine("</xsl:template>");

        sb.AppendLine(GetClassTemplates(type));
        
        sb.AppendLine("</xsl:stylesheet>");
        File.WriteAllText($"{path + type.Name}.xsl", sb.ToString(), Encoding.UTF8);
    }
    
    private static string GetClassFields(Type type)
    {
        var sb = new StringBuilder();
        var properties = type.GetProperties();
        foreach (var property in properties.Where(x => !x.PropertyType.IsClass || x.PropertyType == typeof(string)))
        {
            sb.AppendLine($"<p><strong>{property.Name}: </strong> <xsl:value-of select=\"{property.Name}\"/></p>");
        }
        return sb.ToString();
    }

    private static string GetClassInClass(Type type, string template)
    {
        var sb = new StringBuilder();
        
        sb.AppendLine("<div class=\"section\">");
        sb.AppendLine($"<xsl:apply-templates select=\"{type.Name}\" />");
        sb.AppendLine("</div>");
        
        var properties = type.GetProperties();
        foreach (var property in properties.Where(x => x.PropertyType.IsClass && x.PropertyType != typeof(string) && !x.PropertyType.IsGenericType))
        {
            sb.AppendLine("<div class=\"section\">");
            sb.AppendLine($"<h2>{property.Name}</h2>");
            sb.AppendLine($"<xsl:apply-templates select=\"{template}/{property.PropertyType.Name}\" />");
            sb.AppendLine("</div>");
        }
        
        return sb.ToString();
    }
    
    private static string GetListInClass(Type type, string template)
    {
        var sb = new StringBuilder();
        var properties = type.GetProperties();
        foreach (var property in properties.Where(x => x.PropertyType.IsGenericType))
        {
            sb.AppendLine("<div class=\"section\">");
            sb.AppendLine($"<h2>{property.Name}</h2>");
            sb.AppendLine("<div class=\"section-flex\">");
            sb.AppendLine($"<xsl:apply-templates select=\"{template}/{property.Name}/{property.PropertyType.GenericTypeArguments[0].Name}\" />");
            sb.AppendLine("</div>");
            sb.AppendLine("</div>");
        }
        
        return sb.ToString();
    }

    private static string GetClassTemplates(Type type)
    {
        var sb = new StringBuilder();
        
        sb.AppendLine($"<xsl:template match=\"{type.Name}\">");
        sb.AppendLine("<div class=\"temp-c\">");
        sb.AppendLine(GetClassFields(type));
        sb.AppendLine("</div>");
        sb.AppendLine("</xsl:template>");
        
        var classes = type.GetProperties().Where(x => x.PropertyType.IsClass && x.PropertyType != typeof(string)).ToList();
        foreach (var property in classes)
        {
            var classType = property.PropertyType;
            if (property.PropertyType.IsGenericType)
            {
                classType = property.PropertyType.GenericTypeArguments[0]; 
            }

            sb.AppendLine($"<xsl:template match=\"{classType.Name}\">");
            sb.AppendLine("<div class=\"temp-c\">");
            sb.AppendLine(GetClassFields(classType));
            sb.AppendLine("</div>");
            sb.AppendLine("</xsl:template>");
        }

        return sb.ToString();
    }
}