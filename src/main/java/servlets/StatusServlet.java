package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Status;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 13.03.2017.
 */
public class StatusServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String result = mapper.writeValueAsString(new Status());

        System.out.println(result);

        response.getOutputStream().write(result.getBytes());

        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus( HttpServletResponse.SC_OK );

    }
}
