using System.Xml.Serialization;

namespace AirportConsole.Utils;

public static class XmlGenerator
{
    public static void GenerateXml<T>(T obj, string path)
    {
        var xmlSerializer = new XmlSerializer(typeof(T));
        using var streamWriter = new StreamWriter($"{path + typeof(T).Name}.xml");
        xmlSerializer.Serialize(streamWriter, obj);
    }
}