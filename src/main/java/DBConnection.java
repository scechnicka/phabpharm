import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class allows to connect to the DB on Heroku - static method 'initialiseDB()' returns a Connection object
public class DBConnection {
    public static Connection initialiseDB() throws URISyntaxException, SQLException, ClassNotFoundException {
        String dbDriver = "org.postgresql.Driver";
        String dbUrl = System.getenv("https://projectservlet.herokuapp.com/access?item=products");
        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbUrl);
        return conn;
    }
}