import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        out.println("<html><body>");
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            out.println("<h2>Dashboard - Welcome, " + username + "!</h2>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h2>Please login first.</h2>");
            out.println("<a href='login.html'>Login</a>");
        }
        out.println("</body></html>");
    }
}