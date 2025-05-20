import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set a cookie
        Cookie cookie = new Cookie("username", "student123");
        cookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(cookie);

        // Read cookies
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Cookies:</h2>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>" + c.getName() + ": " + c.getValue() + "</p>");
            }
        } else {
            out.println("<p>No cookies found.</p>");
        }
    }
}
