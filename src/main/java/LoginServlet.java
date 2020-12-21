import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {


@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
        IOException {
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        String name=req.getParameter("uname");
        String password=req.getParameter("psw");

        if ((name.equals("Sarah")) && (password.equals("love")))
        {
                resp.setContentType("text/html");
                resp.getWriter().write("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                        "<style>\n" +
                        "body {margin:0;}\n" +
                        "\n" +
                        ".icon-bar {\n" +
                        "  width: 100%;\n" +
                        "  background-color: #555;\n" +
                        "  overflow: auto;\n" +
                        "}\n" +
                        "\n" +
                        ".icon-bar a {\n" +
                        "  float: left;\n" +
                        "  width: 20%;\n" +
                        "  text-align: center;\n" +
                        "  padding: 12px 0;\n" +
                        "  transition: all 0.3s ease;\n" +
                        "  color: white;\n" +
                        "  font-size: 36px;\n" +
                        "}\n" +
                        "\n" +
                        ".icon-bar a:hover {\n" +
                        "  background-color: #000;\n" +
                        "}\n" +
                        "\n" +
                        ".active {\n" +
                        "  background-color: #4CAF50;\n" +
                        "}\n" +
                        "</style>\n" +
                        "<body>\n" +
                        "\n" +
                        "<div class=\"icon-bar\">\n" +
                        "  <a class=\"active\" href=\"#\"><i class=\"fa fa-home\"></i></a> \n" +
                        "  <a href=\"#\"><i class=\"fa fa-search\"></i></a> \n" +
                        "  <a href=\"#\"><i class=\"fa fa-envelope\"></i></a> \n" +
                        "  <a href=\"#\"><i class=\"fa fa-globe\"></i></a>\n" +
                        "  <a href=\"#\"><i class=\"fa fa-trash\"></i></a> \n" +
                        "</div>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html> \n");
        }
        else
        {
                resp.sendRedirect("/website/");
        }

    }
}
