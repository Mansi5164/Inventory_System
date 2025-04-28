import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import package methods;

public class StationarySection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;

    public StationarySection() {
        inventory = new HashMap<>();
        inventory.put("Books", new HashMap<>());
        inventory.put("Paper", new HashMap<>());
        inventory.put("Writing Instruments", new HashMap<>());
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Sample books
        inventory.get("Books").put("English-Grammar", new Product("English-Grammar", 29.99, 50));
        inventory.get("Books").put("Hindi", new Product("Hindi", 49.99, 30));
        
        // Sample paper products
        inventory.get("Paper").put("Notebook", new Product("Notebook", 59.99, 40));
        inventory.get("Paper").put("Diaries", new Product("Diaries", 39.99, 25));
        inventory.get("Paper").put("Sticky-Notes", new Product("Sticky-Notes", 45.99, 25));
        
        // Sample writing instruments
        inventory.get("Writing Instruments").put("Pen", new Product("Pen", 19.99, 60));
        inventory.get("Writing Instruments").put("Pencils", new Product("Pencils", 24.99, 45));
        inventory.get("Writing Instruments").put("Highlighters", new Product("Highlighters", 20.99, 45));
    }

    public void displayStationaryMenu() {
        while (true) {
            System.out.println("\n=== Stationary Section ===");
            System.out.println("1. Books");
            System.out.println("2. Paper Products");
            System.out.println("3. Writing Instruments");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayCategoryMenu("Books");
                    break;
                case 2:
                    displayCategoryMenu("Paper");
                    break;
                case 3:
                    displayCategoryMenu("Writing Instruments");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }    
} 