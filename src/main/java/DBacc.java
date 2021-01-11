import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DB")
public class DBacc extends HttpServlet {
    GetDB db= new GetDB();
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println(db.getAmount());
        out.println(db.getBrand());
        out.println(db.getSPrice());
        out.println(db.getCategory());
        out.println(db.getCurrentStock());
        out.println(db.getPPrice());
        out.println(db.getFullStock());
        out.println(db.getLimit());
        out.println(db.getDescription());
    }
}
