import java.io.*;
import java.time.LocalDateTime;
import javax.servlet.*;
import javax.servlet.http.*;

public class DateTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        LocalDateTime now = LocalDateTime.now();
        out.println("<html><body>");
        out.println("<h2>Current Date and Time: " + now + "</h2>");
        out.println("</body></html>");
    }
}