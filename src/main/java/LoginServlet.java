import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
        GetDB_clients cdb= new GetDB_clients();
        GetDB db=new GetDB();

        public String encryption (String psw)
        {
                String generatedPassword = null;
                try {
                        // Create MessageDigest instance for MD5
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        //Add password bytes to digest
                        md.update(psw.getBytes());
                        //Get the hash's bytes
                        byte[] bytes = md.digest();
                        //This bytes[] has bytes in decimal format;
                        //Convert it to hexadecimal format
                        StringBuilder sb = new StringBuilder();
                        for(int i=0; i< bytes.length ;i++)
                        {
                                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                        }
                        //Get complete hashed password in hex format
                        generatedPassword = sb.toString();
                } catch (NoSuchAlgorithmException e) {
                        e.printStackTrace();
                }
                return (generatedPassword);
        }

@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
        IOException {

        ArrayList<Product> products_bis  = new ArrayList<>();
        Product product_num = new Product("brand","2",2.0,3.0,1,true,"hello", "cat",2,11);
        products_bis.add(product_num);
        /* NEW CODE BELOW

        String query = "SELECT * FROM products;";

        // 'products_bis' will contain collection of 'Product' objects
        ArrayList<Product> products_bis  = new ArrayList<>();

        try {
                // Connecting to the DB and returning what is identified by the URL
                Connection con = DBConnection.initialiseDB();
                Statement s = con.createStatement();
                ResultSet rset = s.executeQuery(query); // a ResultSet object is a table of data representing a database
                // '.next()' moves cursor to the next row of the DB - loop iterates through result set

                // Iterate through the rows and get info for each product
                while (rset.next()) {
                        String brand = rset.getString(1);
                        String amount = rset.getString(2);
                        double sprice = rset.getDouble(3);
                        double pprice = rset.getDouble(4);
                        int fullstock = rset.getInt(5);
                        boolean limitation = rset.getBoolean(6);
                        String description = rset.getString(7);
                        String category = rset.getString(8);
                        int id = rset.getInt(9);
                        int currentstock = rset.getInt(10);

                        Product product_num = new Product(brand, amount, sprice, pprice, fullstock, limitation, description, category, id, currentstock);

                        // Add one of the products (represented by an ArrayList) to the bigger collection of all products
                        products_bis.add(product_num);
                }

                // here need to attach information as attribute to request - only if certain parameter
                req.setAttribute("products_list", products_bis);
        }
        catch (Exception e) {
                System.out.println("Something went wrong");
        }
         END OF NEW CODE */

        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter(); // is this needed?

        // Get parameters that correspond to the client name and password
        String name=req.getParameter("uname");
        String password=req.getParameter("psw");

        // Encrypt password so that it can be compared with encrypted passwords in the DB
        password=encryption(password);


        if ((cdb.lastName.contains(name)) && (cdb.password.contains(password)))
        {
                req.setAttribute("product_list",products_bis);
                req.getRequestDispatcher("Desktop.jsp").include(req, resp);
                //resp.setContentType("text/html");
                //PrintWriter out4=resp.getWriter();
                //out4.println(products_bis.get(4).getAmount());

        }
        else
        {
                req.getRequestDispatcher("ilogin.jsp").include(req, resp);
                resp.addHeader("REFRESH","1;URL=https://phabonlineshop.herokuapp.com");
        }
    }
}
