package ua.nure;

import ua.nure.entity.Airplane;
import ua.nure.entity.Ticket;
import ua.nure.service.DAOException_Exception;
import ua.nure.service.AirplaneService;



import java.util.Collection;
import java.util.Scanner;

public class Main {
    private static final String CLIENT_TOKEN_VALID = "clientToken";
    private static String CLIENT_TOKEN = "clientToken";
    private static void printMenu() {
        System.out.println("1. Add Airplanes\n" +
                "2. Add ticket\n" +
                "3. Get list airplanes\n" +
                "4. Get ticket\n" +
                "5. Remove airplane\n" +
                "6. Exit\n");
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        AirplaneService client = new ua.nure.service.Airplane().getAirplanePort();
        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        addAirplane(client, sc);
                        break;
                    }
                    case 2 -> {
                        addTicket(client, sc);
                        break;
                    }
                    case 3 -> {
                        listAirplanes(client);
                        break;
                    }
                    case 4 -> {
                        getTicket(client, sc);
                        break;
                    }
                    case 5 -> {
                        removeAirplane(client, sc);
                        break;
                    }

                    case 6 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("[Error] " + e.getMessage());
                e.printStackTrace();
            }
            printMenu();
        }
    }


    private static void addAirplane(AirplaneService service, Scanner scanner) throws DAOException_Exception {
        var airplane = new Airplane();
        System.out.println("Enter airplane title: ");
        String title = scanner.nextLine();
        System.out.println("Enter airplane duration: ");
        String duration = scanner.nextLine();
        System.out.println("Enter airplane destination: ");
        String destination = scanner.nextLine();

        airplane.setAirplaneTitle(title);
        airplane.setDuration(duration);
        airplane.setDestination(destination);

        var request = service.addAirplane(airplane);
        System.out.println("Created airplane with id " + request);
    }

    private static void addTicket(AirplaneService service, Scanner scanner) throws DAOException_Exception {
        var ticket = new Ticket();
        System.out.println("Enter ticket number: ");
        String title = scanner.nextLine();
        System.out.println("Enter airplane duration: ");
        String duration = scanner.nextLine();
        System.out.println("Enter airplane destination: ");
        String destination = scanner.nextLine();
    }

    private static void getTicket(AirplaneService service, Scanner scanner) throws DAOException_Exception {
        System.out.println("Enter ticket number: ");
        String ticketNumber = scanner.nextLine();
        Ticket ticket = service.getTicket(ticketNumber);
        if (ticket != null) {
            System.out.println("Found ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private static void removeAirplane(AirplaneService service, Scanner scanner) throws DAOException_Exception {
        System.out.println("Enter airplane ID: ");
        int airplaneId = Integer.parseInt(scanner.nextLine());
        service.removeAirplane(airplaneId);
        System.out.println("Airplane removed with ID: " + airplaneId);
    }

    private static void listAirplanes(AirplaneService service) throws DAOException_Exception {
        Collection<Airplane> airplanes = service.listAirplanes();
        if (airplanes.isEmpty()) {
            System.out.println("No airplanes found.");
        } else {
            System.out.println("List of airplanes:");
            for (Airplane airplane : airplanes) {
                System.out.println(airplane);
            }
        }
    }

}
