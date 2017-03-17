package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by User on 14.03.2017.
 */
public class LogServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String result = mapper.writeValueAsString(new LogServlet.Log());

        System.out.println(result);

        response.getOutputStream().write(result.getBytes());

        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus( HttpServletResponse.SC_OK );

    }

    static class Log{
        List<String> journal;

        Log() throws IOException {
            Path file = Paths.get("C:\\Users\\User\\IdeaProjects\\simpleserver\\src\\main\\resources\\log1.txt");
            journal = Files.readAllLines(file);
        }

        public List<String> getJournal() {
            return journal;
        }

        public void setJournal(List<String> journal) {
            this.journal = journal;
        }
    }
}
