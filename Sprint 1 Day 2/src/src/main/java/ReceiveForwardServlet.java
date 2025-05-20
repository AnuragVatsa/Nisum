import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ReceiveForwardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String message = (String) request.getAttribute("message");
        out.println("<html><body>");
        out.println("<h2>Received: " + message + "</h2>");
        out.println("</body></html>");
    }
}