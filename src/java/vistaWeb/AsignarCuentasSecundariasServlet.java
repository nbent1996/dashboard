package vistaWeb;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AsignarCuentasSecundariasServlet", urlPatterns = {"/AsignarCuentasSecundariasServlet"})
public class AsignarCuentasSecundariasServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AsignarCuentasSecundariasServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AsignarCuentasSecundariasServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
