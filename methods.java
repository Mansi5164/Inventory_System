public class methods{
    public static void main(String[] args){

    }
    private void displayCategoryMenu(String category) {
        while (true) {
            System.out.println("\n=== " + category + " ===");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Back to Stationary Menu");
            System.out.print("Enter your choice (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayProducts(category);
                    break;
                case 2:
                    addProduct(category);
                    break;
                case 3:
                    updateProduct(category);
                    break;
                case 4:
                    removeProduct(category);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void displayProducts(String category) {
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

    private void addProduct(String category) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        inventory.get(category).put(name, new Product(name, price, quantity));
        System.out.println("Product added successfully!");
    }

    private void updateProduct(String category) {
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
    }

    private void removeProduct(String category) {
        System.out.print("Enter product name to remove: ");
        String name = scanner.nextLine();
        
        if (inventory.get(category).remove(name) != null) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }
}