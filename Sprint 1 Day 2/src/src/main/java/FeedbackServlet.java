import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String feedback = request.getParameter("feedback");
        ServletContext context = getServletContext();
        List<String> feedbackList = (List<String>) context.getAttribute("feedbackList");
        if (feedbackList == null) {
            feedbackList = new ArrayList<>();
            context.setAttribute("feedbackList", feedbackList);
        }
        feedbackList.add(feedback);
        out.println("<html><body>");
        out.println("<h2>Feedback Submitted!</h2>");
        out.println("<a href='viewFeedback'>View All Feedback</a>");
        out.println("</body></html>");
    }
}