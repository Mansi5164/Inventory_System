import java.util.Scanner;

public class InventorySystem {
    private static Scanner scanner = new Scanner(System.in);
    private static ClothingSection clothingSection = new ClothingSection();
    private static StationarySection stationarySection = new StationarySection();
    private static ElectronicsSection electronicsSection = new ElectronicsSection(); // NEW

    public static void main(String[] args) {
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Category 1 selected");
                    break;
                case 2:
                    System.out.println("Category 2 selected");
                    break;
                case 3:
                    stationarySection.displayStationaryMenu();
                    break;
                case 4:
                    clothingSection.displayClothingMenu();
                    break;
                case 5:
                    electronicsSection.displayElectronicsMenu(); // NEW
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
        System.out.println("1. Category 1");
        System.out.println("2. Category 2");
        System.out.println("3. Stationary Section");
        System.out.println("4. Clothing Section");
        System.out.println("5. Electronics Section"); // NEW
        System.out.println("6. Exit"); // UPDATED
        System.out.print("Enter your choice (1-6): ");
    }
}
