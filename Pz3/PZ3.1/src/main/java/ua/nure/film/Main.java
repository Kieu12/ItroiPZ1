//package ua.nure.film;
//
//import ua.nure.film.entity.Film;
//import ua.nure.film.entity.Ticket;
//import ua.nure.film.service.DAOException_Exception;
//import ua.nure.film.service.FilmService;
//import ua.nure.film.service.FilmService;
//
//
//import java.util.Collection;
//import java.util.Scanner;
//
//public class Main {
//    private static final String CLIENT_TOKEN_VALID = "clientToken";
//    private static String CLIENT_TOKEN = "clientToken";
//    private static void printMenu() {
//        System.out.println("1. Add Films\n" +
//                "2. Add ticket\n" +
//                "3. Get list films\n" +
//                "4. Get ticket\n" +
//                "5. Remove film\n" +
//                "6. Exit\n");
//    }
//
//    public static void main(String[] args) throws Exception {
//        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
//        FilmService client = new ua.nure.film.service.Film().getFilmPort();
//        Scanner sc = new Scanner(System.in);
//        printMenu();
//        while (true) {
//            int choise = Integer.valueOf(sc.nextLine());
//            try {
//                switch (choise) {
//                    case 1 -> {
//                        addFilm(client, sc);
//                        break;
//                    }
//                    case 2 -> {
//                        addTicket(client, sc);
//                        break;
//                    }
//                    case 3 -> {
//                        listFilms(client);
//                        break;
//                    }
//                    case 4 -> {
//                        getTicket(client, sc);
//                        break;
//                    }
//                    case 5 -> {
//                        removeFilm(client, sc);
//                        break;
//                    }
//
//                    case 6 -> {
//                        return;
//                    }
//                    default -> {
//                        System.out.println("Invalid option");
//                        break;
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("[Error] " + e.getMessage());
//                e.printStackTrace();
//            }
//            printMenu();
//        }
//    }
//
//    private static void addFilm(FilmService service, Scanner scanner) throws DAOException_Exception {
//        var film = new Film();
//        System.out.println("Enter film title: ");
//        String title = scanner.nextLine();
//        System.out.println("Enter film duration: ");
//        String duration = scanner.nextLine();
//        System.out.println("Enter film show type: ");
//        String showType = scanner.nextLine();
//
//        var request = service.addFilm(film);
//        System.out.println("Created film with id " + request);
//    }
//
//    private static void addTicket(FilmService service, Scanner scanner) throws DAOException_Exception {
//        var ticket = new Ticket();
//        System.out.println("Enter ticket number: ");
//        String title = scanner.nextLine();
//        System.out.println("Enter film duration: ");
//        String duration = scanner.nextLine();
//        System.out.println("Enter film show type: ");
//        String showType = scanner.nextLine();
//    }
//
//    private static void getTicket(FilmService service, Scanner scanner) throws DAOException_Exception {
//        System.out.println("Enter ticket number: ");
//        String ticketNumber = scanner.nextLine();
//        Ticket ticket = service.getTicket(ticketNumber);
//        if (ticket != null) {
//            System.out.println("Found ticket: " + ticket);
//        } else {
//            System.out.println("Ticket not found.");
//        }
//    }
//
//    private static void removeFilm(FilmService service, Scanner scanner) throws DAOException_Exception {
//        System.out.println("Enter film ID: ");
//        int filmId = Integer.parseInt(scanner.nextLine());
//        service.removeFilm(filmId);
//        System.out.println("Film removed with ID: " + filmId);
//    }
//
//    private static void listFilms(FilmService service) throws DAOException_Exception {
//        Collection<Film> films = service.listFilms();
//        if (films.isEmpty()) {
//            System.out.println("No films found.");
//        } else {
//            System.out.println("List of films:");
//            for (Film film : films) {
//                System.out.println(film);
//            }
//        }
//    }
//
//}
