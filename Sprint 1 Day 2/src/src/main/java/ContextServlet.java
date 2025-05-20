import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ContextServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        String param = context.getInitParameter("appVersion");
        out.println("<html><body>");
        out.println("<h2>Context Parameter (appVersion): " + param + "</h2>");
        out.println("</body></html>");
    }
}