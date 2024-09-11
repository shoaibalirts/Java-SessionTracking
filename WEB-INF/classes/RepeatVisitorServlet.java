
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RepeatVisitorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Cookie Example </h2>");
        String msg = "";
        boolean repeatVisitor = false;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                String name = c.getName();
                String val = c.getValue();
                if (name.equals("repeat") && val.equals("yes")) {
                    msg = "Welcome Back";
                    repeatVisitor = true;
                    break;
                }
            }
        }
        if (repeatVisitor == false) {
            Cookie c1 = new Cookie("repeat", "yes");
            c1.setMaxAge(60);
            response.addCookie(c1);
            msg = "Welcome Aboard";
        }
        out.println("</body>");
        out.println("<p>" + msg + "</p>");
        out.println("</html>");
        out.close();
    }

}
