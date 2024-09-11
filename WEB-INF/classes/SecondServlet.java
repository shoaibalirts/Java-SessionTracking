import java.io.*;
import java.net.*;
 import javax.servlet.*;
import javax.servlet.http.*;
public class SecondServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("firstname");
        String sname = request.getParameter("surname");
        String salary = request.getParameter("salary");
        String tax = (String)request.getAttribute("tax");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>SecondServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Welcome " + fname+ " "+sname+ "</h1>");
        out.println("<h3> Salary " + salary+ "</h3>");
        out.println("<h3> Tax " + tax+ "</h3>");
        out.println("</body>");
        out.println("</html>");
        out.close(); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        processRequest(request, response); 

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    } 
}
