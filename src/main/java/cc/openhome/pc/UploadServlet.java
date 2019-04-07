package cc.openhome.pc;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.http.Part;



@MultipartConfig
@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("photo");
        String filename = getFilename(part);
        writeTo(filename, part);
    }

    private String getFilename(Part part){
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
        return filename;
    }
    private void writeTo(String filename,Part part) throws IOException, FileNotFoundException {
        InputStream in = part.getInputStream();
        OutputStream out = new FileOutputStream("/home/ltt/shoucang/"+filename);
        byte[] buffer = new byte[1024];
        int length = -1;
        while((length=in.read(buffer))!=-1){
            out.write(buffer,0,length);
        }
        in.close();
        out.close();
    }
}
