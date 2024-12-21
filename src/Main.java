import java.util.Scanner;

/**
 * The main class that handles user authentication and provides an admin menu for managing products.
 */
public class Main {
    /**
     * The entry point of the program where the admin logs in and manages products.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Authenticate the admin
        Admin admin = Authorization.login();

        if (admin != null) {
            // Admin is authenticated, now they can manage products
            ProductManager productManager = new ProductManager();

            boolean running = true;
            while (running) {
                // Simple menu for admin
                System.out.println("\nAdmin Menu:");
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. List Products");
                System.out.println("4. Logout");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product price (e.g., $780): ");
                        String priceInput = scanner.nextLine();
                        priceInput = priceInput.replaceAll("[^0-9.]", "");  // Remove non-numeric characters
                        double price = Double.parseDouble(priceInput);  // Parse the cleaned value to double
                        productManager.addProduct(new Product(name, price));
                        break;
                    case 2:
                        System.out.print("Enter product name to remove: ");
                        String productName = scanner.nextLine();
                        productManager.removeProduct(productName);
                        break;
                    case 3:
                        productManager.listProducts();
                        break;
                    case 4:
                        running = false;  // Logout
                        System.out.println("Logged out.");
                        break;
                    default:
                        System.out.println("Invalid option, try again.");
                }
            }
        } else {
            System.out.println("You are not authorized to access this system.");
        }
    }
}
