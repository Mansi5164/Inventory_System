import java.util.Scanner;

public class InventorySystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ClothingSection clothingSection = new ClothingSection();
    private static StationarySection stationarySection = new StationarySection();
    private static ElectronicsSection electronicsSection = new ElectronicsSection();
    private static FoodSection foodSection = new FoodSection();
    private static PasswordManager passwordManager = new PasswordManager();

    public static void main(String[] args) {
        // Authenticate user before starting the program
        if (!passwordManager.authenticate()) {
            System.out.println("Authentication failed. Program will exit.");
            System.exit(0);
        }

        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    foodSection.displayFoodMenu();
                    break;
                case 2:
                    stationarySection.displayStationaryMenu();
                    break;
                case 3:
                    clothingSection.displayClothingMenu();
                    break;
                case 4:
                    electronicsSection.displayElectronicsMenu();
                    break;
                case 5:
                    passwordManager.changePassword();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Inventory Management System ===");
        System.out.println("1. Food Section");
        System.out.println("2. Stationary Section");
        System.out.println("3. Clothing Section");
        System.out.println("4. Electronics Section");
        System.out.println("5. Change Password");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-7): ");
    }
}
