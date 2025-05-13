import java.io.*;
import java.util.Scanner;

public class PasswordManager {
    private static final String PASSWORD_FILE = "inventory_data/password.dat";
    private static final String DEFAULT_PASSWORD = "admin123"; // Default password for first run
    private Scanner scanner = new Scanner(System.in);

    public PasswordManager() {
        // Create password file if it doesn't exist
        File file = new File(PASSWORD_FILE);
        if (!file.exists()) {
            savePassword(DEFAULT_PASSWORD);
        }
    }

    public boolean authenticate() {
        String storedPassword = loadPassword();
        int attempts = 3; // Number of login attempts allowed

        while (attempts > 0) {
            System.out.println("\n=== Inventory System Login ===");
            System.out.println("Attempts remaining: " + attempts);
            System.out.print("Enter password: ");
            String inputPassword = scanner.nextLine();

            if (inputPassword.equals(storedPassword)) {
                System.out.println("Login successful!");
                return true;
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Incorrect password. Please try again.");
                } else {
                    System.out.println("Too many failed attempts. Program will exit.");
                }
            }
        }
        return false;
    }

    public void changePassword() {
        System.out.println("\n=== Change Password ===");
        System.out.print("Enter current password: ");
        String currentPassword = scanner.nextLine();

        if (!currentPassword.equals(loadPassword())) {
            System.out.println("Current password is incorrect!");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        System.out.print("Confirm new password: ");
        String confirmPassword = scanner.nextLine();

        if (newPassword.equals(confirmPassword)) {
            savePassword(newPassword);
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Passwords do not match!");
        }
    }

    private void savePassword(String password) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PASSWORD_FILE))) {
            oos.writeObject(password);
        } catch (IOException e) {
            System.err.println("Error saving password: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private String loadPassword() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PASSWORD_FILE))) {
            return (String) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading password: " + e.getMessage());
            return DEFAULT_PASSWORD;
        }
    }
} 