import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StationarySection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private Methods methods;
    private FileManager fileManager;

    public StationarySection() {
        fileManager = new FileManager();
        inventory = fileManager.loadInventory("Stationary");
        
        // Initialize categories if they don't exist
        if (inventory.isEmpty()) {
            inventory = new HashMap<>();
            inventory.put("Pens", new HashMap<>());
            inventory.put("Notebooks", new HashMap<>());
            inventory.put("Art Supplies", new HashMap<>());
            initializeSampleData();
            fileManager.saveInventory("Stationary", inventory);
        }
        
        methods = new Methods(inventory);
    }

    private void initializeSampleData() {
        // Sample Pens
        inventory.get("Pens").put("Ballpoint Pen", new Product("Ballpoint Pen", 1.99, 100,"xyz"));
        inventory.get("Pens").put("Gel Pen", new Product("Gel Pen", 2.99, 80,"xyz"));

        // Sample Notebooks
        inventory.get("Notebooks").put("Spiral Notebook", new Product("Spiral Notebook", 4.99, 50,"xyz"));
        inventory.get("Notebooks").put("Composition Book", new Product("Composition Book", 3.99, 60,"xyz"));

        // Sample Art Supplies
        inventory.get("Art Supplies").put("Watercolors", new Product("Watercolors", 12.99, 30,"xyz"));
        inventory.get("Art Supplies").put("Sketch Pencils", new Product("Sketch Pencils", 8.99, 40,"xyz"));
    }

    public void displayStationaryMenu() {
        while (true) {
            System.out.println("\n=== Stationary Section ===");
            System.out.println("1. Pens");
            System.out.println("2. Notebooks");
            System.out.println("3. Art Supplies");
            System.out.println("4. Save Changes");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    methods.displayCategoryMenu("Pens");
                    fileManager.saveInventory("Stationary", inventory);
                    break;
                case 2:
                    methods.displayCategoryMenu("Notebooks");
                    fileManager.saveInventory("Stationary", inventory);
                    break;
                case 3:
                    methods.displayCategoryMenu("Art Supplies");
                    fileManager.saveInventory("Stationary", inventory);
                    break;
                case 4:
                    fileManager.saveInventory("Stationary", inventory);
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