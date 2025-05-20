import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("<html><body>");
        if ("admin".equals(username) && "password123".equals(password)) {
            out.println("<h2>Login Successful!</h2>");
        } else {
            out.println("<h2>Login Failed. Invalid credentials.</h2>");
        }
        out.println("</body></html>");
    }
}