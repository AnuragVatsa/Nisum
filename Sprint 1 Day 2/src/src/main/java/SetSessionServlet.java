import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("user", "Alice");
        session.setAttribute("role", "Admin");
        out.println("<html><body>");
        out.println("<h2>Session Attributes Set!</h2>");
        out.println("<a href='readSession'>Read Session</a>");
        out.println("</body></html>");
    }
}