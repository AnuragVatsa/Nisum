import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewFeedbackServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();
        List<String> feedbackList = (List<String>) context.getAttribute("feedbackList");
        out.println("<html><body>");
        out.println("<h2>All Feedback</h2>");
        if (feedbackList != null && !feedbackList.isEmpty()) {
            for (String feedback : feedbackList) {
                out.println(feedback + "<br>");
            }
        } else {
            out.println("No feedback available.");
        }
        out.println("</body></html>");
    }
}