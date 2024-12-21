/**
 * Represents a product with a name and price.
 */
public class Product {
    /**
     * The name of the product.
     */
    String name;

    /**
     * The price of the product.
     */
    double price;

    /**
     * Creates a new product with the given name and price.
     * 
     * @param name  The name of the product.
     * @param price The price of the product.
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the product.
     * 
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     * 
     * @return The product price.
     */
    public double getPrice() {
        return price;
    }
}
