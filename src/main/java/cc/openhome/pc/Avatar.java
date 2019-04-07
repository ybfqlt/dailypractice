package cc.openhome.pc;


import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        urlPatterns={"/avatar.view"},
        initParams={
                @WebInitParam(name="AVATAR_DIR",value="/avatars")
        }
)
public class Avatar extends HttpServlet {
    private String AVATAR_DIR;
    @Override
    public void init() throws ServletException{
        AVATAR_DIR = getInitParameter("AVATAR_DIR");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>头像显示</title>");
        out.println("</head>");
        out.println("<body>");
        for(String avatar : getServletContext().getResourcePaths(AVATAR_DIR)){
            //out.println(avatar);
            avatar = avatar.replaceFirst("/","");   //->   /avatars/75fc6cc3ee49db97618dddaf5970b719.jpg
            out.println("<img src='" + avatar + "'> "+avatar+""); //   avatars/75fc6cc3ee49db97618dddaf5970b719.jpg
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
