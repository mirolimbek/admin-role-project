import java.util.ArrayList;
import java.util.List;

/**
 * Manages a collection of products, including adding, removing, and listing products.
 */
public class ProductManager {
    /**
     * A list of products managed by the ProductManager.
     */
    List<Product> products = new ArrayList<>();

    /**
     * Adds a new product to the product list.
     * 
     * @param product The product to add.
     */
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product.getName());
    }

    /**
     * Removes a product from the list by name.
     * 
     * @param productName The name of the product to remove.
     */
    public void removeProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                System.out.println("Product removed: " + productName);
                return;
            }
        }
        System.out.println("Product not found!");
    }

    /**
     * Lists all products in the product list.
     */
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Products list:");
        for (Product product : products) {
            System.out.println("Name: " + product.getName() + ", Price: " + product.getPrice());
        }
    }
}
