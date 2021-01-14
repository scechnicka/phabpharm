
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet ("/welcome")
public class MyServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html");

        //resp.getWriter().write();
        RequestDispatcher view = req.getRequestDispatcher("C:\\Users\\Sarah\\Desktop\\Year3\\Prg3\\phabpharm\\web\\WEB-INF\\login.html");
        view.forward(req, resp);
    }
}


