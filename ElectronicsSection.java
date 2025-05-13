import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ElectronicsSection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private Methods methods;
    private FileManager fileManager;

    public ElectronicsSection() {
        fileManager = new FileManager();
        inventory = fileManager.loadInventory("Electronics");
        
        // Initialize categories if they don't exist
        if (inventory.isEmpty()) {
            inventory = new HashMap<>();
            inventory.put("Mobiles", new HashMap<>());
            inventory.put("Laptops", new HashMap<>());
            inventory.put("Accessories", new HashMap<>());
            initializeSampleData();
            fileManager.saveInventory("Electronics", inventory);
        }
        
        methods = new Methods(inventory);
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
            System.out.println("4. Save Changes");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    methods.displayCategoryMenu("Mobiles");
                    fileManager.saveInventory("Electronics", inventory);
                    break;
                case 2:
                    methods.displayCategoryMenu("Laptops");
                    fileManager.saveInventory("Electronics", inventory);
                    break;
                case 3:
                    methods.displayCategoryMenu("Accessories");
                    fileManager.saveInventory("Electronics", inventory);
                    break;
                case 4:
                    fileManager.saveInventory("Electronics", inventory);
                    System.out.println("Changes saved successfully!");
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

