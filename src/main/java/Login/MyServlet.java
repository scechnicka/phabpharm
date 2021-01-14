package Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/website")
public class MyServlet extends HttpServlet {
    //int count = 0;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        //resp.setContentType("text/html");
        resp.setContentType("text/html;charset=UTF-8");
        //if (count != 0) {

        //}
        //count++;

        //resp.getWriter().write();
        RequestDispatcher view = req.getRequestDispatcher("Login\\login.html");
        // don't add your web-app name to the path

        view.forward(req, resp);
    }
}


