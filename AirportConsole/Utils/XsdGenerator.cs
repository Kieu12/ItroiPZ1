using System.Text;
using System.Xml;
using System.Xml.Serialization;

namespace AirportConsole.Utils;

public static class XsdGenerator
{
    public static void GenerateXsd(string path, Type type)
    {
        var schemas = new XmlSchemas();
        var exporter = new XmlSchemaExporter(schemas);
        var mapping = new XmlReflectionImporter().ImportTypeMapping(type);
        exporter.ExportTypeMapping(mapping);
        XmlWriterSettings settingsA = new XmlWriterSettings
        {
            Indent = true,
            Encoding = new UTF8Encoding(false)
        };

        using (XmlWriter writer = XmlWriter.Create($"{path}{type.Name}.xsd", settingsA))
        {
            schemas.First().Write(writer);;
        }
    }
}