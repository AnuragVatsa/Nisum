import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        out.println("<html><body>");
        if (name == null || name.trim().isEmpty()) {
            out.println("<h2>Error: Name is required.</h2>");
        } else if (email == null || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            out.println("<h2>Error: Invalid email format.</h2>");
        } else {
            out.println("<h2>Success: Data validated!</h2>");
            out.println("Name: " + name + "<br>");
            out.println("Email: " + email);
        }
        out.println("</body></html>");
    }
}