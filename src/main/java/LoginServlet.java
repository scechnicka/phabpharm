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

        if ((name.equals("Sarah")) && (password.equals("love"))) {
                out.print(name);
                out.print(password);
        }
        else
        {
                resp.sendRedirect("/website/");
        }

    }
}
