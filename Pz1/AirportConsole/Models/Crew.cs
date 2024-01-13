using AirportConsole.Models.Base;

namespace AirportConsole.Models;

public class Crew : EntityWithId
{
    public string Name { get; set; } = null!;
    public string Position { get; set; } = null!;
    public int Flight_Id { get; set; }
    public List<Ticket> Tickets { get; set; } 

}