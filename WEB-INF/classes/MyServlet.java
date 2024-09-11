import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MyServlet extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String fname = req.getParameter("firstname");
        String sname = req.getParameter("surname");
        PrintWriter out = res.getWriter();
        out.println("Hello "+fname+" "+sname);
        out.close();
    }
}
