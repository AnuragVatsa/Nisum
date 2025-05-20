import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfigServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletConfig config = getServletConfig();
        String email = config.getInitParameter("adminEmail");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Admin Email: " + email + "</h2>");
    }
}
