import java.util.*;

class Reservation {
    String name, from, to, date, classType;
    int trainNo;

    public Reservation(String name, int trainNo, String from, String to, String date, String classType) {
        this.name = name;
        this.trainNo = trainNo;
        this.from = from;
        this.to = to;
        this.date = date;
        this.classType = classType;
    }

    public void display() {
        System.out.println("\nReservation Details:");
        System.out.println("Name: " + name);
        System.out.println("Train No: " + trainNo);
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Date: " + date);
        System.out.println("Class: " + classType);
    }
}

public class ReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static Map<Integer, Reservation> reservations = new HashMap<>();
    static int pnr = 1000;

    public static void main(String[] args) {
        System.out.print("Enter username: ");
        String user = sc.next();
        System.out.print("Enter password: ");
        String pass = sc.next();

        if (user.equals("admin") && pass.equals("1234")) {
            System.out.println("Login successful!");

            while (true) {
                System.out.println("\n1. Reserve Ticket\n2. Cancel Ticket\n3. Exit");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        bookTicket();
                        break;
                    case 2:
                        cancelTicket();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Login failed.");
        }
    }

    public static void bookTicket() {
        System.out.print("Enter Name: ");
        String name = sc.next();
        System.out.print("Enter Train No: ");
        int trainNo = sc.nextInt();
        System.out.print("From: ");
        String from = sc.next();
        System.out.print("To: ");
        String to = sc.next();
        System.out.print("Journey Date (DD-MM-YYYY): ");
        String date = sc.next();
        System.out.print("Class (Sleeper/AC): ");
        String classType = sc.next();

        Reservation res = new Reservation(name, trainNo, from, to, date, classType);
        reservations.put(pnr, res);
        System.out.println("Ticket booked! Your PNR is: " + pnr);
        pnr++;
    }

    public static void cancelTicket() {
        System.out.print("Enter your PNR: ");
        int cancelPnr = sc.nextInt();
        if (reservations.containsKey(cancelPnr)) {
            reservations.remove(cancelPnr);
            System.out.println("Ticket Cancelled Successfully!");
        } else {
            System.out.println("Invalid PNR.");
        }
    }
}
