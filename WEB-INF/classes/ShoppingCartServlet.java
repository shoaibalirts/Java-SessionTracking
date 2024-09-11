
import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ShoppingCartServlet extends HttpServlet {

    public static int S_ID = 1;
    public static HashMap<String, HashMap> globalMap = new HashMap<String, HashMap>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HashMap<String, String> sessionInfo = null;
        String sID = "";
        Cookie c = findCookie(request);
        if (c == null) {
            sID = makeUniqueString();
            sessionInfo = new HashMap<String, String>();
            globalMap.put(sID, sessionInfo);
            Cookie sessionCookie = new Cookie("JSESSIONID", sID);
            response.addCookie(sessionCookie);
        } else {
            sessionInfo = (HashMap<String, String>) globalMap.get(c.getValue());
        }
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Shooping Cart Example</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Online Book Store</h1>");
        String url = "http://localhost:8084/cookiesessionex/shoppingcartex";
        out.println("<form action=" + url + ">"
                + "<h3><input type=checkbox name=firstCB value=firstCB />"
                + " java core servlts</h3>" + "<br>"
                + "<h3> < input type = checkbox name = secondCB value = secondCB /> " + " java how to program</h3>"
                + "<br>"
                + "<h3><input type=checkbox name=thirdCB value=thirdCB />" + " java complete reference</h3>"
                + "<br>"
                + "<input type=submit value=\"Add to Cart\" />" + "</from>"
        );
        out.println("<br/>");
        out.println("<h1>You have selected followig books</h1>");
        out.println("<br/>");
        // retrieving params of check boxes
        String fBook = request.getParameter("firstCB");
        String sBook = request.getParameter("secondCB");
        String tBook = request.getParameter("thirdCB");

        if (fBook != null && fBook == "firstCB") {
            sessionInfo.put("firstCB", "Java Core Servlets");
        }
        if (sBook != null && sBook == "secondCB") {
            sessionInfo.put("secondCB", "Java How to Program");
        }
        if (tBook != null && tBook == "thirdCB") {
            sessionInfo.put("thirdCB", "Java complete reference");
        }
        // display books stored in global hashmap
        printSessionInfo(out, sessionInfo);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    public String makeUniqueString() {
        return "ABC" + S_ID++;
    }

    public static HashMap findTableStoringSessions() {
        return globalMap;
    }

    public Cookie findCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals("JSESSIONID")) {
                    return c;
                }
            }
        }
        return null;
    }

    public void printSessionInfo(PrintWriter out,
            HashMap sessionInfo) {
        String title = "";
        title = (String) sessionInfo.get("firstCB");
        if (title != null) {
            out.println("<h3> " + title + "</h3>");
        }
        title = (String) sessionInfo.get("secondCB");
        if (title != null) {
            out.println("<h3> " + title + "</h3>");
        }
        title = (String) sessionInfo.get("thirdCB");
        if (title != null) {
            out.println("<h3> " + title + "</h3>");
        }
    }
}
