using AirportConsole.Models.Base;

namespace AirportConsole.Models;

public class Flight : EntityWithId
{
    public string Depart { get; set; } = null!;
    public string Destin { get; set; } = null!;
    public List<Crew> Crews { get; set; } = null!;
    public List<Passanger> Passangers { get; set; } = null!;
    public List<Ticket> Tickets { get; set; } = null!;

}