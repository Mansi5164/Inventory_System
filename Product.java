// import java.io.Serializable;

// public class Product implements Serializable {
//     private String name;
//     private double price;
//     private int quantity;

//     public Product(String name, double price, int quantity) {
//         this.name = name;
//         this.price = price;
//         this.quantity = quantity;
//     }

//     public String getName() {
//         return name;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public int getQuantity() {
//         return quantity;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setPrice(double price) {
//         this.price = price;
//     }

//     public void setQuantity(int quantity) {
//         this.quantity = quantity;
//     }
// } 


import java.io.Serializable;

public class Product implements Serializable {
    // private static final long serialVersionUID = -8886958463451334361L;

    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(String name, double price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getDescription() { return description; }

    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setDescription(String description) { this.description = description; }
}
