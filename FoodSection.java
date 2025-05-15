import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodSection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private Methods methods;
    private FileManager fileManager;

    public FoodSection() { 
        fileManager = new FileManager();
        inventory = fileManager.loadInventory("Food");
        
        // Initialize categories if they don't exist
        if (inventory.isEmpty()) {
            inventory = new HashMap<>();
            inventory.put("Groceries", new HashMap<>());
            inventory.put("Beverages", new HashMap<>());
            inventory.put("Snacks", new HashMap<>());
            initializeSampleData();
            fileManager.saveInventory("Food", inventory);
        }
        
        methods = new Methods(inventory);
    }

    private void initializeSampleData() {
    // Sample Groceries
    inventory.get("Groceries").put("Rice", new Product("Rice", 29.99, 50, "Premium Basmati Rice"));
    inventory.get("Groceries").put("Flour", new Product("Flour", 19.99, 40, "Whole Wheat Flour"));

    // Sample Beverages
    inventory.get("Beverages").put("Coffee", new Product("Coffee", 9.99, 30, "Instant Coffee Powder"));
    inventory.get("Beverages").put("Tea", new Product("Tea", 7.99, 35, "Organic Green Tea"));

    // Sample Snacks
    inventory.get("Snacks").put("Chips", new Product("Chips", 3.99, 100, "Salted Potato Chips"));
    inventory.get("Snacks").put("Cookies", new Product("Cookies", 4.99, 80, "Chocolate Chip Cookies"));
}


    public void displayFoodMenu() {
        while (true) {
            System.out.println("\n=== Food Section ===");
            System.out.println("1. Groceries");
            System.out.println("2. Beverages");
            System.out.println("3. Snacks");
            System.out.println("4. Save Changes");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    methods.displayCategoryMenu("Groceries");
                    fileManager.saveInventory("Food", inventory);
                    break;
                case 2:
                    methods.displayCategoryMenu("Beverages");
                    fileManager.saveInventory("Food", inventory);
                    break;
                case 3:
                    methods.displayCategoryMenu("Snacks");
                    fileManager.saveInventory("Food", inventory);
                    break;
                case 4:
                    fileManager.saveInventory("Food", inventory);
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

