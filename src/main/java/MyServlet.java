
import javax.servlet.RequestDispatcher;
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


@WebServlet (name = "MyServlet", urlPatterns = {"/MyServlet"})
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
        RequestDispatcher view = req.getRequestDispatcher("/login.html");
        // don't add your web-app name to the path

        view.forward(req, resp);
    }
}


