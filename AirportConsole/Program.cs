using AirportConsole.Models;
using AirportConsole.Utils;

var path = "C:\\Users\\kieuh\\Desktop\\4 Kurs\\itroi\\Airport\\AirportConsole\\xml\\";

XmlGenerator.GenerateXml(EntityGenerator.GetConstCrew(), path);
XsdGenerator.GenerateXsd(path,typeof(Crew));
XslGenerator.GenerateXslSchema(typeof(Crew), path);
HtmlGenerator.GenerateHtml(path, typeof(Crew));

XmlGenerator.GenerateXml(EntityGenerator.GetConstPassanger(), path);
XsdGenerator.GenerateXsd(path,typeof(Passanger));
XslGenerator.GenerateXslSchema(typeof(Passanger), path);
HtmlGenerator.GenerateHtml(path, typeof(Passanger));

XmlGenerator.GenerateXml(EntityGenerator.GetConstTicket(), path);
XsdGenerator.GenerateXsd(path,typeof(Ticket));
XslGenerator.GenerateXslSchema(typeof(Ticket), path);
HtmlGenerator.GenerateHtml(path, typeof(Ticket));

XmlGenerator.GenerateXml(EntityGenerator.GetConstFlight(), path);
XsdGenerator.GenerateXsd(path,typeof(Flight));
XslGenerator.GenerateXslSchema(typeof(Flight), path);
HtmlGenerator.GenerateHtml(path, typeof(Flight));
