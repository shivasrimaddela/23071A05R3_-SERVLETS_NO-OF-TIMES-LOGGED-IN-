import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("loginCount");
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        session.setAttribute("loginCount", count);

        out.println("<html><body>");
        out.println("<h2>Hello, " + username + "!</h2>");
        out.println("<p>You have logged in " + count + " times during this session.</p>");
        out.println("</body></html>");
    }
}
