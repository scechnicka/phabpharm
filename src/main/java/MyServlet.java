
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


@WebServlet ("/welcome")
public class MyServlet extends HttpServlet {
    int count =0;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html");
        if (count != 0) {
            resp.getWriter().write("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<script>\n" +
                    "  alert(\"You username or password is incorrect. Try again!\");\n" +
                    "</script>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>\n");
        }
        count++;
        resp.getWriter().write("<html>\n" +
                "<head>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<style>\n" +
                "body {font-family: Arial, Helvetica, sans-serif;}\n" +
                "\n" +
                "/* Full-width input fields */\n" +
                "input[type=text], input[type=password] {\n" +
                "  width: 100%;\n" +
                "  padding: 12px 20px;\n" +
                "  margin: 8px 0;\n" +
                "  display: inline-block;\n" +
                "  border: 1px solid #ccc;\n" +
                "  box-sizing: border-box;\n" +
                "}\n" +
                "\n" +
                "/* Set a style for all buttons */\n" +
                "button {\n" +
                "  background-color: #4CAF50;\n" +
                "  color: white;\n" +
                "  padding: 14px 20px;\n" +
                "  margin: 8px 0;\n" +
                "  border: none;\n" +
                "  cursor: pointer;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "button:hover {\n" +
                "  opacity: 0.8;\n" +
                "}\n" +
                "\n" +
                "/* Extra styles for the cancel button */\n" +
                ".cancelbtn {\n" +
                "  width: auto;\n" +
                "  padding: 10px 18px;\n" +
                "  background-color: #f44336;\n" +
                "}\n" +
                "\n" +
                "/* Center the image and position the close button */\n" +
                ".imgcontainer {\n" +
                "  text-align: center;\n" +
                "  margin: 24px 0 12px 0;\n" +
                "  position: relative;\n" +
                "}\n" +
                "\n" +
                ".container {\n" +
                "  padding: 16px;\n" +
                "}\n" +
                "\n" +
                "span.psw {\n" +
                "  float: right;\n" +
                "  padding-top: 16px;\n" +
                "}\n" +
                "\n" +
                "/* The Modal (background) */\n" +
                ".modal {\n" +
                "  display: none; /* Hidden by default */\n" +
                "  position: fixed; /* Stay in place */\n" +
                "  z-index: 1; /* Sit on top */\n" +
                "  left: 0;\n" +
                "  top: 0;\n" +
                "  width: 100%; /* Full width */\n" +
                "  height: 100%; /* Full height */\n" +
                "  overflow: auto; /* Enable scroll if needed */\n" +
                "  background-color: rgb(0,0,0); /* Fallback color */\n" +
                "  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n" +
                "  padding-top: 60px;\n" +
                "}\n" +
                "\n" +
                "/* Modal Content/Box */\n" +
                ".modal-content {\n" +
                "  background-color: #fefefe;\n" +
                "  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */\n" +
                "  border: 1px solid #888;\n" +
                "  width: 80%; /* Could be more or less, depending on screen size */\n" +
                "}\n" +
                "\n" +
                "/* The Close Button (x) */\n" +
                ".close {\n" +
                "  position: absolute;\n" +
                "  right: 25px;\n" +
                "  top: 0;\n" +
                "  color: #000;\n" +
                "  font-size: 35px;\n" +
                "  font-weight: bold;\n" +
                "}\n" +
                "\n" +
                ".close:hover,\n" +
                ".close:focus {\n" +
                "  color: red;\n" +
                "  cursor: pointer;\n" +
                "}\n" +
                "\n" +
                "/* Add Zoom Animation */\n" +
                ".animate {\n" +
                "  -webkit-animation: animatezoom 0.6s;\n" +
                "  animation: animatezoom 0.6s\n" +
                "}\n" +
                "\n" +
                "@-webkit-keyframes animatezoom {\n" +
                "  from {-webkit-transform: scale(0)} \n" +
                "  to {-webkit-transform: scale(1)}\n" +
                "}\n" +
                "  \n" +
                "@keyframes animatezoom {\n" +
                "  from {transform: scale(0)} \n" +
                "  to {transform: scale(1)}\n" +
                "}\n" +
                "\n" +
                "/* Change styles for span and cancel button on extra small screens */\n" +
                "@media screen and (max-width: 300px) {\n" +
                "  span.psw {\n" +
                "     display: block;\n" +
                "     float: none;\n" +
                "  }\n" +
                "  .cancelbtn {\n" +
                "     width: 100%;\n" +
                "  }\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "\n" +
                "<h1>Welcome to Phab Pharmacy's online shop Phindr</h1>\n" +
                "<img src=\"C:\\Users\\Sarah\\Desktop\\University\\Year3\\Prg3\\website\\logo.jpg\" alt=\"Logo\" width=\"500\" height=\"333\">" +
                "<p>Please log in with your <b>login details</b> below </p>" +
                "<button onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\">Login</button>\n" +
                "\n" +
                "<div id=\"id01\" class=\"modal\">\n" +
                "  \n" +
                "  <form class=\"modal-content animate\" action=\"login\" method=\"post\">\n" +
                "    <div class=\"imgcontainer\">\n" +
                "      <span onclick=\"document.getElementById('id01').style.display='none'\" class=\"close\" title=\"Close Modal\">&times;</span>\n" +
                "\n" +
                "    <div class=\"container\">\n" +
                "      <label for=\"uname\"><b>Username</b></label>\n" +
                "      <input type=\"text\" placeholder=\"Enter Username\" name=\"uname\" required>\n" +
                "\n" +
                "      <label for=\"psw\"><b>Password</b></label>\n" +
                "      <input type=\"password\" placeholder=\"Enter Password\" name=\"psw\" required>\n" +
                "        \n" +
                "      <button type=\"submit\">Login</button>\n" +
                "      <label>\n" +
                "        <input type=\"checkbox\" checked=\"checked\" name=\"remember\"> Remember me\n" +
                "      </label>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"container\" style=\"background-color:#f1f1f1\">\n" +
                "      <button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" class=\"cancelbtn\">Cancel</button>\n" +
                "      <span class=\"psw\">Forgot <a href=\"#\">password?</a></span>\n" +
                "    </div>\n" +
                "  </form>\n" +
                "</div>\n" +
                "\n" +
                "<script>\n" +
                "// Get the modal\n" +
                "var modal = document.getElementById('id01');\n" +
                "\n" +
                "// When the user clicks anywhere outside of the modal, close it\n" +
                "window.onclick = function(event) {\n" +
                "    if (event.target == modal) {\n" +
                "        modal.style.display = \"none\";\n" +
                "    }\n" +
                "}\n" +
                "</script>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n");
    }
    }


