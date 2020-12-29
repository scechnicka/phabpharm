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

        if ((name.equals("Sarah")) && (password.equals("5f4dcc3b5aa765d61d8327deb882cf99")))
        {
                resp.setContentType("text/html");
                resp.getWriter().write("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<h1>Welcome to the Phab Pharmacy online store!</h1>\n" +
                        "<p>Pick the relevant options in each dropdown menu or search for the medicine you are looking for and checkout to order your drug.</p>\n" +
                        "\n" +
                        "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                        "<style>\n" +
                        "* {box-sizing: border-box;}\n" +
                        "\n" +
                        "body {\n" +
                        "  margin: 0;\n" +
                        "  font-family: Arial, Helvetica, sans-serif;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav {\n" +
                        "  overflow: hidden;\n" +
                        "  background-color: #e9e9e9;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav a {\n" +
                        "  float: left;\n" +
                        "  display: block;\n" +
                        "  color: black;\n" +
                        "  text-align: center;\n" +
                        "  padding: 14px 16px;\n" +
                        "  text-decoration: none;\n" +
                        "  font-size: 17px;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav a:hover {\n" +
                        "  background-color: #ddd;\n" +
                        "  color: black;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav a.active {\n" +
                        "  background-color: #2196F3;\n" +
                        "  color: white;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav .search-container {\n" +
                        "  float: right;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav input[type=text] {\n" +
                        "  padding: 6px;\n" +
                        "  margin-top: 8px;\n" +
                        "  font-size: 17px;\n" +
                        "  border: none;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav .search-container button {\n" +
                        "  float: right;\n" +
                        "  padding: 6px 10px;\n" +
                        "  margin-top: 8px;\n" +
                        "  margin-right: 16px;\n" +
                        "  background: #ddd;\n" +
                        "  font-size: 17px;\n" +
                        "  border: none;\n" +
                        "  cursor: pointer;\n" +
                        "}\n" +
                        "\n" +
                        ".topnav .search-container button:hover {\n" +
                        "  background: #ccc;\n" +
                        "}\n" +
                        "\n" +
                        "@media screen and (max-width: 600px) {\n" +
                        "  .topnav .search-container {\n" +
                        "    float: none;\n" +
                        "  }\n" +
                        "  .topnav a, .topnav input[type=text], .topnav .search-container button {\n" +
                        "    float: none;\n" +
                        "    display: block;\n" +
                        "    text-align: left;\n" +
                        "    width: 100%;\n" +
                        "    margin: 0;\n" +
                        "    padding: 14px;\n" +
                        "  }\n" +
                        "  .topnav input[type=text] {\n" +
                        "    border: 1px solid #ccc;  \n" +
                        "  }\n" +
                        "}\n" +
                        "\n" +
                        "}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "</style>\n" +
                        "\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "<div class=\"topnav\">\n" +
                        "  <a class=\"active\" href=\"#home\">Home</a>\n" +
                        "  <div class=\"search-container\">\n" +
                        "    <form action=\"/action_page.php\">\n" +
                        "      <input type=\"text\" placeholder=\"Search..\" name=\"search\">\n" +
                        "      <button type=\"submit\"><i class=\"fa fa-search\"></i></button>\n" +
                        "    </form>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "<br>\n" +
                        "<br>\n" +
                        "<br>\n" +
                        "\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<style>\n" +
                        ".dropbtn {\n" +
                        "  background-color: #4CAF50;\n" +
                        "  color: white;\n" +
                        "  padding: 16px;\n" +
                        "  font-size: 16px;\n" +
                        "  border: none;\n" +
                        "}\n" +
                        "\n" +
                        ".dropdown {\n" +
                        "  position: relative;\n" +
                        "  display: inline-block;\n" +
                        "}\n" +
                        "\n" +
                        ".dropdown-content {\n" +
                        "  display: none;\n" +
                        "  position: absolute;\n" +
                        "  background-color: #f1f1f1;\n" +
                        "  min-width: 160px;\n" +
                        "  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" +
                        "  z-index: 1;\n" +
                        "}\n" +
                        "\n" +
                        ".dropdown-content a {\n" +
                        "  color: black;\n" +
                        "  padding: 12px 16px;\n" +
                        "  text-decoration: none;\n" +
                        "  display: block;\n" +
                        "}\n" +
                        "\n" +
                        ".dropdown-content a:hover {background-color: #ddd;}\n" +
                        "\n" +
                        ".dropdown:hover .dropdown-content {display: block;}\n" +
                        "\n" +
                        ".dropdown:hover .dropbtn {background-color: #3e8e41;}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "\n" +
                        "<div class=\"dropdown\">\n" +
                        "  <button class=\"dropbtn\">Select a medicine type</button>\n" +
                        "  <div class=\"dropdown-content\">\n" +
                        "    <a href=\"#\">Link 1</a>\n" +
                        "    <a href=\"#\">Link 2</a>\n" +
                        "    <a href=\"#\">Link 3</a>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "<div class=\"dropdown\">\n" +
                        "  <button class=\"dropbtn\">Select a medicine brand</button>\n" +
                        "  <div class=\"dropdown-content\">\n" +
                        "    <a href=\"#\">Link 1</a>\n" +
                        "    <a href=\"#\">Link 2</a>\n" +
                        "    <a href=\"#\">Link 3</a>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "<div class=\"dropdown\">\n" +
                        "  <button class=\"dropbtn\">Select a quantity</button>\n" +
                        "  <div class=\"dropdown-content\">\n" +
                        "    <a href=\"#\">Link 1</a>\n" +
                        "    <a href=\"#\">Link 2</a>\n" +
                        "    <a href=\"#\">Link 3</a>\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "<br>\n" +
                        "<br>\n" +
                        "<br>\n" +
                        "\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<style>\n" +
                        ".block {\n" +
                        "  display: block;\n" +
                        "  width: 100%;\n" +
                        "  border: none;\n" +
                        "  background-color: #4CAF50;\n" +
                        "  color: white;\n" +
                        "  padding: 14px 28px;\n" +
                        "  font-size: 16px;\n" +
                        "  cursor: pointer;\n" +
                        "  text-align: center;\n" +
                        "}\n" +
                        "\n" +
                        ".block:hover {\n" +
                        "  background-color: #ddd;\n" +
                        "  color: black;\n" +
                        "}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\n" +
                        "<button class=\"block\">Checkout</button>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>");
        }
        else
        {
                resp.sendRedirect("/website/welcome");
        }

    }
}
