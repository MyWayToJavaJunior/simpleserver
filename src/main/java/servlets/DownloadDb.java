package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Anton on 16.03.2017.
 */
public class DownloadDb extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Download");
        PrintWriter out = response.getWriter();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\simpleserver\\src\\main\\resources\\log1.txt");
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + "log1.txt" + "\"");
        response.setContentLength((int) new File("C:\\Users\\User\\IdeaProjects\\simpleserver\\src\\main\\resources\\log1.txt").length());
        int i;
        while ((i = fileInputStream.read()) != -1) {
            out.write(i);
        }
        fileInputStream.close();
        out.close();
    }
}
