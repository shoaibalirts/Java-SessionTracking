import java.io.*;
import java.net.*;
import java.text.ParseException;
import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname");
        String sname = request.getParameter("surname");
        String salary = request.getParameter("salary");
        int sal = Integer.parseInt(salary);
        int tax = (int)(sal*0.30);
        String taxValue = tax + "";
        request.setAttribute("tax",taxValue);

        ServletContext sContext = getServletContext();
        RequestDispatcher rd = sContext.getRequestDispatcher("/secondservlet");
        rd.forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
