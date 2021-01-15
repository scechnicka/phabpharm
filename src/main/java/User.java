import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    public static boolean Check(String password, String username) {
        boolean test=false;
        try {
            Connection con = DBConnection.initialiseDB();
            Statement s = con.createStatement();
            ResultSet rset = s.executeQuery("SELECT * from clients where name="+username+" AND password="+password+";");
            // a ResultSet object is a table of data representing a database
            // '.next()' moves cursor to the next row of the DB - loop iterates through result set

            test = rset.next(); // as the cursor is positioned before the first row it returns 'false' if there is no row and thus no user corresponding to this name and password
        }
        catch(Exception e) {
            System.out.println("Something went wrong");
        }

        return test;
    }
}