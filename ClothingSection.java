import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import package ClothingSection;

public class ClothingSection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;

    public ClothingSection() {
        inventory = new HashMap<>();
        inventory.put("Men", new HashMap<>());
        inventory.put("Women", new HashMap<>());
        inventory.put("Kids", new HashMap<>());
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Sample men's products
        inventory.get("Men").put("T-Shirt", new Product("T-Shirt", 29.99, 50));
        inventory.get("Men").put("Jeans", new Product("Jeans", 49.99, 30));
        
        // Sample women's products
        inventory.get("Women").put("Dress", new Product("Dress", 59.99, 40));
        inventory.get("Women").put("Blouse", new Product("Blouse", 39.99, 25));
        
        // Sample kids' products
        inventory.get("Kids").put("T-Shirt", new Product("Kids T-Shirt", 19.99, 60));
        inventory.get("Kids").put("Shorts", new Product("Kids Shorts", 24.99, 45));
    }

    public void displayClothingMenu() {
        while (true) {
            System.out.println("\n=== Clothing Section ===");
            System.out.println("1. Men's Clothing");
            System.out.println("2. Women's Clothing");
            System.out.println("3. Kids' Clothing");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayCategoryMenu("Men");
                    break;
                case 2:
                    displayCategoryMenu("Women");
                    break;
                case 3:
                    displayCategoryMenu("Kids");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
} 