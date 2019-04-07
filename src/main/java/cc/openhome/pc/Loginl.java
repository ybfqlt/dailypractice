package cc.openhome.pc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginl.do")
public class Loginl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String passwd = request.getParameter("passwd");
        if("caterpillar".equals(user)&&"123456".equals(passwd)) {
            request.getSession().setAttribute("login",user);
            request.getRequestDispatcher("/userl.view").forward(request,response);
        }else{
            response.sendRedirect("loginl.html");
        }
    }
}
