import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get username and password from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Get session and initialize login count
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("loginCount");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("loginCount", count);

        // Display response
        out.println("<html><body>");
        out.println("<h2>Hello, " + username + "!</h2>");
        out.println("<p>You have logged in " + count + " times during this session.</p>");
        out.println("</body></html>");
    }
}
