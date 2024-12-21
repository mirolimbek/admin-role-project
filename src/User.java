public class User {
    String username;
    String password;

    // Constructor to create a new user
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters for username and password
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
