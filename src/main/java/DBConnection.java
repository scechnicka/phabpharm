import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* This class allows to connect to the DB associated to our app on Heroku - static method 'initialiseDB()' returns a Connection object */
/* This class would have been used if we managed to connect to the DB directly */

public class DBConnection {
    public static Connection initialiseDB() throws URISyntaxException, SQLException, ClassNotFoundException {
        String dbDriver = "org.postgresql.Driver";
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        Class.forName(dbDriver);
        Connection conn = DriverManager.getConnection(dbUrl);
        return conn;
    }
}