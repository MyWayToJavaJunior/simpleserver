package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Status;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 14.03.2017.
 */
public class LogsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String result = mapper.writeValueAsString(new Logs());

        System.out.println(result);

        response.getOutputStream().write(result.getBytes());

        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus( HttpServletResponse.SC_OK );

    }

    static class Logs{
        List<String> logs;
        Logs(){
            logs = new ArrayList<>();
            logs.addAll(Arrays.asList("Log1", "Log2", "Log3"));
        }

        public List<String> getLogs() {
            return logs;
        }

        public void setLogs(List<String> logs) {
            this.logs = logs;
        }
    }
}
