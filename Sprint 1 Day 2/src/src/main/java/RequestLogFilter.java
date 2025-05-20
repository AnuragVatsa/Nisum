import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestLogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("Request URL: " + req.getRequestURI());
        chain.doFilter(request, response);
    }

    public void destroy() {}
}