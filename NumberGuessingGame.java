package Scanner;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int randomNumber = random.nextInt(100) + 1;
        int maxAttempts = 5;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have picked a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
                scanner.next(); // Clear invalid input
                continue;
            }

            int userGuess = scanner.nextInt();
            
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please enter a number within the range of 1 to 100.");
                continue;
            }

            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }

            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry! You've used all your attempts. The correct number was " + randomNumber + ".");
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }
}
