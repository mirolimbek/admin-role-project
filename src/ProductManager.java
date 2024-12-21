import java.io.*;
import java.util.*;

public class ProductManager {

    private static final String FILE_NAME = "products.txt";  // File where product data will be stored

    /**
     * Adds a new product to the list and saves it to the file.
     *
     * @param product The product to be added.
     */
    public void addProduct(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            // Write product to file (name and price)
            writer.write(product.getName() + "," + product.getPrice());
            writer.newLine();  // Add a new line after the product entry
            System.out.println("Product added: " + product.getName() + " - $" + product.getPrice());
        } catch (IOException e) {
            System.err.println("Error adding product to file: " + e.getMessage());
        }
    }

    /**
     * Removes a product from the list and updates the file.
     *
     * @param productName The name of the product to be removed.
     */
    public void removeProduct(String productName) {
        File tempFile = new File("temp_products.txt");  // Temporary file for writing
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean productFound = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equalsIgnoreCase(productName)) {
                    productFound = true;  // Product found, do not write to the new file
                    continue;  // Skip writing this line to remove the product
                }
                // If product is not found, copy the line to the new file
                writer.write(line);
                writer.newLine();
            }

            if (productFound) {
                // Replace the original file with the new file
                if (tempFile.renameTo(new File(FILE_NAME))) {
                    System.out.println("Product removed: " + productName);
                } else {
                    System.err.println("Error updating product list.");
                }
            } else {
                System.out.println("Product not found: " + productName);
            }

        } catch (IOException e) {
            System.err.println("Error removing product from file: " + e.getMessage());
        }
    }

    /**
     * Lists all products stored in the file.
     */
    public void listProducts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\nProduct List:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("Name: " + parts[0] + ", Price: $" + parts[1]);
            }
        } catch (IOException e) {
            System.err.println("Error reading product list: " + e.getMessage());
        }
    }
}
