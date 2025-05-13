import java.util.Map;
import java.util.Scanner;

public class Methods {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Map<String, Product>> inventory;
    private FileManager fileManager;
    private String currentSection;

    public Methods(Map<String, Map<String, Product>> inventory) {
        this.inventory = inventory;
        this.fileManager = new FileManager();
    }

    public void setCurrentSection(String section) {
        this.currentSection = section;
    }

    public void displayCategoryMenu(String category) {
        setCurrentSection(category);
        while (true) {
            System.out.println("\n=== " + category + " ===");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Back to Section Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayProducts(category);
                    break;
                case 2:
                    addProduct(category);
                    fileManager.saveInventory(currentSection, inventory);
                    break;
                case 3:
                    updateProduct(category);
                    fileManager.saveInventory(currentSection, inventory);
                    break;
                case 4:
                    removeProduct(category);
                    fileManager.saveInventory(currentSection, inventory);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayProducts(String category) {
        System.out.println("\n=== " + category + " Products ===");
        Map<String, Product> products = inventory.get(category);
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("-------------------");
        }
    }

    public void addProduct(String category) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.get(category).put(name, new Product(name, price, quantity));
        System.out.println("Product added successfully!");
        displayProducts(category);
    }

    public void updateProduct(String category) {
        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();
        
        if (!inventory.get(category).containsKey(name)) {
            System.out.println("Product not found!");
            return;
        }

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.get(category).put(name, new Product(name, price, quantity));
        System.out.println("Product updated successfully!");
        displayProducts(category);
    }

    public void removeProduct(String category) {
        System.out.print("Enter product name to remove: ");
        String name = scanner.nextLine();
        
        if (inventory.get(category).remove(name) != null) {
            System.out.println("Product removed successfully!");
            displayProducts(category);
        } else {
            System.out.println("Product not found!");
        }
    }
} 