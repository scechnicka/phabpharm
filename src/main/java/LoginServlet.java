import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String name=req.getParameter("uname");
        String password=req.getParameter("psw");
        password=encryption(password);

        if ((cdb.lastName.contains(name)) && (cdb.password.contains(password)))
        {
                req.getRequestDispatcher("Desktop.jsp").include(req, resp);
        }
        else
        {
                req.getRequestDispatcher("ilogin.jsp").include(req, resp);
                resp.addHeader("REFRESH","1;URL=https://phabonlineshop.herokuapp.com");
        }
    }
}
