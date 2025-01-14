package Scanner;

import java.util.Scanner;

//Class for basic arithmetic operations
class ArithmeticOperations {
 // Method for addition
 public double add(double a, double b) {
     return a + b;
 }

 // Method for subtraction
 public double subtract(double a, double b) {
     return a - b;
 }

 // Method for multiplication
 public double multiply(double a, double b) {
     return a * b;
 }

 // Method for division
 public double divide(double a, double b) {
     if (b == 0) {
         throw new ArithmeticException("Division by zero is not allowed.");
     }
     return a / b;
 }
}

public class CalculatorApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     ArithmeticOperations operations = new ArithmeticOperations();

     System.out.println("Welcome to the Arithmetic Calculator!");
     System.out.print("Enter the first number: ");
     double num1 = scanner.nextDouble();

     System.out.print("Enter the second number: ");
     double num2 = scanner.nextDouble();

     System.out.println("Choose an operation:");
     System.out.println("1. Addition");
     System.out.println("2. Subtraction");
     System.out.println("3. Multiplication");
     System.out.println("4. Division");
     System.out.print("Enter your choice (1-4): ");

     int choice = scanner.nextInt();

     try {
         double result;
         switch (choice) {
             case 1:
                 result = operations.add(num1, num2);
                 System.out.println("Result: " + result);
                 break;
             case 2:
                 result = operations.subtract(num1, num2);
                 System.out.println("Result: " + result);
                 break;
             case 3:
                 result = operations.multiply(num1, num2);
                 System.out.println("Result: " + result);
                 break;
             case 4:
                 result = operations.divide(num1, num2);
                 System.out.println("Result: " + result);
                 break;
             default:
                 System.out.println("Invalid choice. Please select a number between 1 and 4.");
         }
     } catch (ArithmeticException e) {
         System.out.println(e.getMessage());
     }

     System.out.println("Thank you for using the Arithmetic Calculator!");
     scanner.close();
 }
}

