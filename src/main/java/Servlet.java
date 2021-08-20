import Homepage.Homepage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            Homepage.start();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        request.setAttribute("dataList", Homepage.getDataList());
    }

}
