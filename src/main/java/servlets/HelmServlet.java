package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Anton on 16.03.2017.
 */
public class HelmServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        String result = mapper.writeValueAsString(new Helm());


        response.getOutputStream().write(result.getBytes());

        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus( HttpServletResponse.SC_OK );

    }

    static class Helm{
        String helm_state;
        String helm_mode_type;
        String helm_mode_name;
        String helm_mode_time;

        Helm(){
            this.helm_mode_name = "some name";
            this.helm_mode_time = "some time";
            this.helm_mode_type = "some type";
            this.helm_state = "some sate";
        }

        public String getHelm_state() {
            return helm_state;
        }

        public void setHelm_state(String helm_state) {
            this.helm_state = helm_state;
        }

        public String getHelm_mode_type() {
            return helm_mode_type;
        }

        public void setHelm_mode_type(String helm_mode_type) {
            this.helm_mode_type = helm_mode_type;
        }

        public String getHelm_mode_name() {
            return helm_mode_name;
        }

        public void setHelm_mode_name(String helm_mode_name) {
            this.helm_mode_name = helm_mode_name;
        }

        public String getHelm_mode_time() {
            return helm_mode_time;
        }

        public void setHelm_mode_time(String helm_mode_time) {
            this.helm_mode_time = helm_mode_time;
        }
    }
}
