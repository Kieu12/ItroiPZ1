using AirportConsole.Models.Base;

namespace AirportConsole.Models;

public class Passanger : EntityWithId
{
    public string Name { get; set; } = null!;
    public string Passport_Num { get; set; } = null!;
    public string Email { get; set; } = null!;
    public List<Ticket> Tickets { get; set; } 
}