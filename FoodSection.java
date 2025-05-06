import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoodSection {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private Methods methods;

    public FoodSection() {
        inventory = new HashMap<>();
        inventory.put("Flour", new HashMap<>());
        inventory.put("Pulses", new HashMap<>());
        inventory.put("Rice", new HashMap<>());
        methods = new Methods(inventory);
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Sample Mobiles
        inventory.get("Flour").put("Atta", new Product("Atta", 100.99, 10));
        inventory.get("Flour").put("Basen", new Product("Basen", 212.99, 8));

        // Sample Laptops
        inventory.get("Pulses").put("Chana Dal", new Product("Chana Dal", 99.99, 5));
        inventory.get("Pulses").put("Masoor Dal", new Product("Masoor Dal", 79.99, 7));

        // Sample Accessories
        inventory.get("Rice").put("Basmati", new Product("Basmati", 399.99, 20));
        inventory.get("Rice").put("Brown Rice", new Product("Brown Rice", 449.99, 25));
    }

    public void displayFoodMenu() {
        while (true) {
            System.out.println("\n=== Food Section ===");
            System.out.println("1. Flour");
            System.out.println("2. Pulses");
            System.out.println("3. Rice");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    methods.displayCategoryMenu("Flour");
                    break;
                case 2:
                    methods.displayCategoryMenu("Pulses");
                    break;
                case 3:
                    methods.displayCategoryMenu("Rice");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

