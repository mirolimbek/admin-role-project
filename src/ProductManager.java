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
        File file = new File(FILE_NAME);  // Original product file
        List<String> lines = new ArrayList<>();  // To hold the file content

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean productFound = false;

            // Read all lines from the file and store them in the list
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String storedProductName = parts[0].trim();  // Trim the stored product name for comparison
                if (storedProductName.equalsIgnoreCase(productName.trim())) {
                    productFound = true;  // Product found, do not add to the list
                    continue;  // Skip adding this line to remove the product
                }
                // If product is not found, add the line to the list
                lines.add(line);
            }

            if (productFound) {
                // Write the updated content back to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String lineToWrite : lines) {
                        writer.write(lineToWrite);
                        writer.newLine();
                    }
                    System.out.println("Product removed: " + productName);
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
