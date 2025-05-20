import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("message", "Hello from ForwardServlet!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/receiveForward");
        dispatcher.forward(request, response);
    }
}