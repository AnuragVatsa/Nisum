import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DisplayInputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        out.println("<html><body>");
        out.println("<h2>User Input</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Email: " + email);
        out.println("</body></html>");
    }
}