import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Form2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        String name = (session != null) ? (String) session.getAttribute("name") : "Unknown";
        String email = request.getParameter("email");
        out.println("<html><body>");
        out.println("<h2>Form Data</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Email: " + email);
        out.println("</body></html>");
    }
}