import org.junit.jupiter.api.*;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for ProductManager.
 */
public class ProductManagerTest {

    private static final String FILE_NAME = "products.txt";
    private ProductManager productManager;

    @BeforeEach
    public void setUp() {
        // Initialize ProductManager before each test
        productManager = new ProductManager();

        // Clear the file before each test to start with a fresh state
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");  // Clear the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddProduct() {
        // Add a product
        Product product = new Product("Test Product", 100.0);
        productManager.addProduct(product);

        // Verify that the product is added to the file
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            assertNotNull(line, "Product should be added to the file.");
            assertTrue(line.contains("Test Product"), "Product name should be present in the file.");
            assertTrue(line.contains("100.0"), "Product price should be present in the file.");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading file after adding product.");
        }
    }

    @Test
    public void testRemoveProduct() {
        // Add a product first to ensure we have something to remove
        Product product = new Product("Product To Remove", 50.0);
        productManager.addProduct(product);

        // Remove the product
        productManager.removeProduct("Product To Remove");

        // Verify that the product is removed from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            assertNull(line, "File should be empty after product removal.");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading file after removing product.");
        }
    }

    @Test
    public void testListProducts() {
        // Add multiple products
        Product product1 = new Product("Product 1", 20.0);
        Product product2 = new Product("Product 2", 30.0);
        productManager.addProduct(product1);
        productManager.addProduct(product2);

        // List products and check if they are displayed correctly
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();

            assertNotNull(line1, "First product should be listed.");
            assertNotNull(line2, "Second product should be listed.");
            assertTrue(line1.contains("Product 1"), "Product 1 name should be present.");
            assertTrue(line2.contains("Product 2"), "Product 2 name should be present.");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Error reading file when listing products.");
        }
    }

    @AfterEach
    public void tearDown() {
        // Clean up: Clear the file after each test
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("");  // Clear the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
