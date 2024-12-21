public class Admin extends User {

    // Constructor for admin that calls the User constructor
    public Admin(String username, String password) {
        super(username, password);
    }

    // Admin-specific methods can be added here (like managing products)
}
