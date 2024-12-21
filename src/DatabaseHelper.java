import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseHelper {
    public static void createDatabase() {
        String url = "jdbc:sqlite:admin_role.db"; // Path to your database file

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS products (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "price REAL NOT NULL);";
                stmt.execute(sql);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

