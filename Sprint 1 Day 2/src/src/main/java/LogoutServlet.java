import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        out.println("<html><body>");
        out.println("<h2>Logged Out Successfully!</h2>");
        out.println("<a href='login.html'>Login Again</a>");
        out.println("</body></html>");
    }
}