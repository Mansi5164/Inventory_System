import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClothingSection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private Methods methods;
    private FileManager fileManager;

    public ClothingSection() {
        fileManager = new FileManager();
        inventory = fileManager.loadInventory("Clothing");
        
        // Initialize categories if they don't exist
        if (inventory.isEmpty()) {
            inventory = new HashMap<>();
            inventory.put("Men's Wear", new HashMap<>());
            inventory.put("Women's Wear", new HashMap<>());
            inventory.put("Accessories", new HashMap<>());
            initializeSampleData();
            fileManager.saveInventory("Clothing", inventory);
        }
        
        methods = new Methods(inventory);
    }

    private void initializeSampleData() {
        // Sample Men's Wear
        inventory.get("Men's Wear").put("T-Shirt", new Product("T-Shirt", 24.99, 50));
        inventory.get("Men's Wear").put("Jeans", new Product("Jeans", 49.99, 30));

        // Sample Women's Wear
        inventory.get("Women's Wear").put("Dress", new Product("Dress", 39.99, 40));
        inventory.get("Women's Wear").put("Blouse", new Product("Blouse", 29.99, 45));

        // Sample Accessories
        inventory.get("Accessories").put("Belt", new Product("Belt", 19.99, 25));
        inventory.get("Accessories").put("Scarf", new Product("Scarf", 14.99, 35));
    }

    public void displayClothingMenu() {
        while (true) {
            System.out.println("\n=== Clothing Section ===");
            System.out.println("1. Men's Wear");
            System.out.println("2. Women's Wear");
            System.out.println("3. Accessories");
            System.out.println("4. Save Changes");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    methods.displayCategoryMenu("Men's Wear");
                    fileManager.saveInventory("Clothing", inventory);
                    break;
                case 2:
                    methods.displayCategoryMenu("Women's Wear");
                    fileManager.saveInventory("Clothing", inventory);
                    break;
                case 3:
                    methods.displayCategoryMenu("Accessories");
                    fileManager.saveInventory("Clothing", inventory);
                    break;
                case 4:
                    fileManager.saveInventory("Clothing", inventory);
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