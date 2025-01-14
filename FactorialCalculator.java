package Scanner;

import java.util.Scanner;

public class FactorialCalculator {

    // Recursive method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Factorial Calculator!");
        System.out.print("Enter a non-negative integer: ");

        try {
            int number = scanner.nextInt();

            if (number < 0) {
                System.out.println("Error: Factorial is not defined for negative numbers.");
            } else {
                long result = factorial(number);
                System.out.println("The factorial of " + number + " is: " + result);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid non-negative integer.");
        } finally {
            scanner.close();
        }
    }
}
