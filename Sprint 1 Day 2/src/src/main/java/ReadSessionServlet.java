import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        out.println("<html><body>");
        out.println("<h2>Session Attributes</h2>");
        if (session != null) {
            out.println("User: " + session.getAttribute("user") + "<br>");
            out.println("Role: " + session.getAttribute("role"));
        } else {
            out.println("No session found.");
        }
        out.println("</body></html>");
    }
}