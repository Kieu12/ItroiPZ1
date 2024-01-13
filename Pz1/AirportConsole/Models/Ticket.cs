using AirportConsole.Models.Base;

namespace AirportConsole.Models;

public class Ticket : EntityWithId
{
    public int Flight_Id { get; set; }
    public float Price { get; set; }
    public string Seat { get; set; } = null!;
    public string Class { get; set; } = null!;
    
}