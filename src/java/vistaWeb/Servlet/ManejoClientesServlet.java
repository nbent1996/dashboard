
package vistaWeb.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vistaWeb.VistaManejoClientesWeb;


@WebServlet(name = "ManejoClientesServlet", urlPatterns = {"/ManejoClientesServlet"})
public class ManejoClientesServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        VistaManejoClientesWeb vista = new VistaManejoClientesWeb(request, response);
        vista.procesarRequest(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }

    
}
