package Scanner;

import java.sql.*;
import java.util.Scanner;
import java.sql.DriverManager;

public class LibraryManagementSystem {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Yash@1234";

    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database.");
            Class.forName("com.mysql.cj.jdbc.Driver");


            while (true) {
                System.out.println("\nLibrary Management System:");
                System.out.println("1. Add Book");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. View Books");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        addBook(connection, title, author);
                        break;
                    case 2:
                        System.out.print("Enter book ID to borrow: ");
                        int borrowId = scanner.nextInt();
                        borrowBook(connection, borrowId);
                        break;
                    case 3:
                        System.out.print("Enter book ID to return: ");
                        int returnId = scanner.nextInt();
                        returnBook(connection, returnId);
                        break;
                    case 4:
                        viewBooks(connection);
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addBook(Connection connection, String title, String author) {
        String sql = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setBoolean(3, true);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void borrowBook(Connection connection, int bookId) {
        String checkSql = "SELECT available FROM books WHERE id = ?";
        String updateSql = "UPDATE books SET available = ? WHERE id = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkSql);
             PreparedStatement updateStmt = connection.prepareStatement(updateSql)) {
            checkStmt.setInt(1, bookId);
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next() && rs.getBoolean("available")) {
                updateStmt.setBoolean(1, false);
                updateStmt.setInt(2, bookId);
                updateStmt.executeUpdate();
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book is not available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void returnBook(Connection connection, int bookId) {
        String sql = "UPDATE books SET available = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, true);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
            System.out.println("Book returned successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewBooks(Connection connection) {
        String sql = "SELECT * FROM books";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nBooks in Library:");
            while (rs.next()) {
                System.out.printf("ID: %d, Title: %s, Author: %s, Available: %s%n",
                        rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getBoolean("available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

