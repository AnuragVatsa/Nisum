import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Form1Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        response.sendRedirect("form2.html");
    }
}