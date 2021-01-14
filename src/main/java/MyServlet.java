
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
        //resp.getWriter().write(login.html);

        RequestDispatcher view = req.getRequestDispatcher("html/login.html");
        view.forward(req, resp);

    }
    }


