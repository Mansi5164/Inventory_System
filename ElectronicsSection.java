import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectronicsSection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private Methods methods;

    public ElectronicsSection() {
        inventory = new HashMap<>();
        inventory.put("Mobiles", new HashMap<>());
        inventory.put("Laptops", new HashMap<>());
        inventory.put("Accessories", new HashMap<>());
        methods = new Methods(inventory);
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Sample Mobiles
        inventory.get("Mobiles").put("iPhone 14", new Product("iPhone 14", 999.99, 10));
        inventory.get("Mobiles").put("Samsung Galaxy S23", new Product("Samsung Galaxy S23", 899.99, 8));

        // Sample Laptops
        inventory.get("Laptops").put("MacBook Pro", new Product("MacBook Pro", 1999.99, 5));
        inventory.get("Laptops").put("Dell XPS 13", new Product("Dell XPS 13", 1299.99, 7));

        // Sample Accessories
        inventory.get("Accessories").put("AirPods", new Product("AirPods", 199.99, 20));
        inventory.get("Accessories").put("Wireless Charger", new Product("Wireless Charger", 49.99, 25));
    }

    public void displayElectronicsMenu() {
        while (true) {
            System.out.println("\n=== Electronics Section ===");
            System.out.println("1. Mobiles");
            System.out.println("2. Laptops");
            System.out.println("3. Accessories");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    methods.displayCategoryMenu("Mobiles");
                    break;
                case 2:
                    methods.displayCategoryMenu("Laptops");
                    break;
                case 3:
                    methods.displayCategoryMenu("Accessories");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

