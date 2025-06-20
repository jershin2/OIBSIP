import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int numberToGuess = rand.nextInt(100) + 1;
        int attempts = 0;
        int guess = 0;

        System.out.println("Guess a number between 1 and 100");

        while (guess != numberToGuess) {
            System.out.print("Enter guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! Guessed in " + attempts + " tries.");
            }
        }
        sc.close();
    }
}
