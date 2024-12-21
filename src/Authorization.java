import java.util.Scanner;

public class Authorization {
    // Method to authenticate an admin
    public static Admin login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Hardcoded credentials for simplicity
        if (username.equals("Miro") && password.equals("Miro01")) {
            return new Admin(username, password);  // Return an Admin object if successful
        } else {
            System.out.println("Invalid credentials!");
            return null;
        }
    }
}
