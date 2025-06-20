import java.util.Scanner;

public class OnlineExam {
    static Scanner sc = new Scanner(System.in);
    static String user = "student";
    static String pass = "1234";

    public static void main(String[] args) {
        if (login()) {
            startExam();
        } else {
            System.out.println("Invalid login!");
        }
    }

    public static boolean login() {
        System.out.print("Username: ");
        String uname = sc.next();
        System.out.print("Password: ");
        String pwd = sc.next();
        return uname.equals(user) && pwd.equals(pass);
    }

    public static void startExam() {
        int score = 0;
        System.out.println("---- Exam Started ----");
        System.out.println("Q1. What is Java?\n1. OS\n2. Language\n3. Game\n4. App");
        if (sc.nextInt() == 2) score++;

        System.out.println("Q2. Who invented Java?\n1. James Gosling\n2. Bill Gates\n3. Elon Musk\n4. Steve Jobs");
        if (sc.nextInt() == 1) score++;

        System.out.println("Q3. Full form of JVM?\n1. Java Visual Machine\n2. Java Virtual Machine\n3. Java Version Machine\n4. None");
        if (sc.nextInt() == 2) score++;

        System.out.println("Your score is: " + score + "/3");
        logout();
    }

    public static void logout() {
        System.out.println("Logging out...");
    }
}