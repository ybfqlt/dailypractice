package cc.openhome.pc;


import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/some.view")
public class DispatcherDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("Some do one...");
        RequestDispatcher dispatcher = request.getRequestDispatcher("other.view");
        dispatcher.include(request, response);
        out.println("Some do two...");
        out.close();
    }
}
