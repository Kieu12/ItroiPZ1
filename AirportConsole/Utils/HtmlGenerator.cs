using System.Xml.Xsl;

namespace AirportConsole.Utils;

public static class HtmlGenerator
{
    public static void GenerateHtml(string path, Type type)
    {
        XslCompiledTransform xslt = new XslCompiledTransform();

        xslt.Load($"{path}{type.Name}.xsl");
        xslt.Transform($"{path}{type.Name}.xml", $"{path}{type.Name}.html");
    }
}