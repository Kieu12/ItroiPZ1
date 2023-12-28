using AirportConsole.Models;

namespace AirportConsole.Utils;

public static class EntityGenerator
{
    public static Flight GetConstFlight()
    {
        var flight = new Flight()
        {
            Id = 1,
            Depart = "Departure",
            Destin = "Destination",
            Passangers = new List<Passanger>()
            {
                GetConstPassanger(),
                
                new Passanger()
                {
                    Id = 2,
                    Name = "Name",
                    Passport_Num = "Passport Number",
                    Email = "Email",
                    Tickets = new List<Ticket>()
                    {
                        GetConstTicket()
                    }
                }
            },
            Crews = new List<Crew>
            {
                GetConstCrew(),
                
                new Crew()
                {
                    Id = 2,
                    Name = "Name",
                    Position = "Position",
                    Flight_Id = 1,
                    Tickets = new List<Ticket>()
                    {
                        GetConstTicket()
                    }
                }
            },
            Tickets = new List<Ticket>()
            {
                GetConstTicket(),
                new Ticket()
                {
                    Flight_Id = 2,
                    Price = 0,
                    Seat = "Seat",
                    Class = "Class"
                }
            } 
        };
        return flight;
    }

    public static Crew GetConstCrew()
    {
        return new Crew()
        {
            Id = 1,
            Name = "Name",
            Position = "Position",
            Flight_Id = 1,
            Tickets = new List<Ticket>()
            {
                GetConstTicket()
            }
        };
    }

    public static Passanger GetConstPassanger()
    {
        return new Passanger
        {
            Id = 1,
            Name = "Name",
            Passport_Num = "Passport Number",
            Email = "Email",
            Tickets = new List<Ticket>()
            {
                GetConstTicket()
            }
        };
    }

    public static Ticket GetConstTicket()
    {
        return new Ticket
        {
            Id = 1,
            Flight_Id = 1,
            Price = 0 ,
            Seat = "Seat",
            Class = "Class"
        };
    }
}