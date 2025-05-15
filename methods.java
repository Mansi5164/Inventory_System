import java.util.*;

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
            System.out.println("5. Search Product");
            System.out.println("6. Backup");
            System.out.println("7. Restore");
            System.out.println("8. Back to Section Menu");
            System.out.print("Enter your choice (1-8): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    searchProduct(category);
                    break;
                case 6:
                    fileManager.backupInventory(currentSection);
                    break;
                case 7:
                    inventory.put(category, fileManager.restoreInventory(currentSection));
                    break;
                case 8:
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
            System.out.println("No products available or category not found.");
            return;
        }

        List<Product> productList = new ArrayList<>(products.values());

        System.out.println("Sort by:");
        System.out.println("1. Name A-Z");
        System.out.println("2. Name Z-A");
        System.out.println("3. Price Low to High");
        System.out.println("4. Price High to Low");
        System.out.println("5. Quantity Low to High");
        System.out.println("6. Quantity High to Low");
        System.out.print("Choose sorting option (1-6): ");

        int sortChoice = scanner.nextInt();
        scanner.nextLine();

        switch (sortChoice) {
            case 1:
                productList.sort(Comparator.comparing(Product::getName));
                break;
            case 2:
                productList.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case 3:
                productList.sort(Comparator.comparingDouble(Product::getPrice));
                break;
            case 4:
                productList.sort(Comparator.comparingDouble(Product::getPrice).reversed());
                break;
            case 5:
                productList.sort(Comparator.comparingInt(Product::getQuantity));
                break;
            case 6:
                productList.sort(Comparator.comparingInt(Product::getQuantity).reversed());
                break;
            default:
                System.out.println("Invalid choice. Showing unsorted list.");
        }

        for (Product product : productList) {
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Description: " + product.getDescription());
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
        scanner.nextLine();
<<<<<<< HEAD
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
=======
>>>>>>> 5298ab02b39be76234dc4456bca084bc0bece107

        inventory.get(category).put(name, new Product(name, price, quantity, description));
        System.out.println("Product added successfully!");
    }

    public void updateProduct(String category) {
        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();

<<<<<<< HEAD
        Product product = inventory.get(category).get(name);
        if (product == null) {
            System.out.println("Product not found.");
=======
        if (!inventory.get(category).containsKey(name)) {
            System.out.println("Product not found!");
>>>>>>> 5298ab02b39be76234dc4456bca084bc0bece107
            return;
        }

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
<<<<<<< HEAD
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
=======
>>>>>>> 5298ab02b39be76234dc4456bca084bc0bece107

        inventory.get(category).put(name, new Product(name, price, quantity, description));
        System.out.println("Product updated successfully!");
        displayProducts(category);
    }

    public void searchProduct(String category) {
        System.out.print("Enter product name or keyword: ");
        String query = scanner.nextLine().toLowerCase();

        Map<String, Product> products = inventory.get(category);
        boolean found = false;
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(query) ||
                product.getDescription().toLowerCase().contains(query)) {
                System.out.println("Name: " + product.getName());
                System.out.println("Price: $" + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("Description: " + product.getDescription());
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) System.out.println("No matching product found.");
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
<<<<<<< HEAD
}
=======
}
>>>>>>> 5298ab02b39be76234dc4456bca084bc0bece107
