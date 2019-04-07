package cc.openhome.pc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello.view")
public class HelloView extends HttpServlet {
        private String htmlTemplate =
                "<html>"
                +"<head>"
                +"   <meta http-equiv='Content-Type'"
                +"      content='text/html; charset=UTF-8'>"
                +"   <title>%s</title>"
                +"   </head>"
                +"   <body>"
                +"       <h1>%s</h1>"
                +"   </body>"
                +"</html>";
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String user = request.getParameter("user");
            String message = (String) request.getAttribute("message");
            String html = String.format(htmlTemplate,user,message);
            response.getWriter().print(html);
    }
}
