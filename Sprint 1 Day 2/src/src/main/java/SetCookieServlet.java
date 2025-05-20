import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SetCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie cookie = new Cookie("username", "JohnDoe");
        cookie.setMaxAge(3600); // 1 hour
        response.addCookie(cookie);
        out.println("<html><body>");
        out.println("<h2>Cookie Set!</h2>");
        out.println("<a href='readCookie'>Read Cookie</a>");
        out.println("</body></html>");
    }
}