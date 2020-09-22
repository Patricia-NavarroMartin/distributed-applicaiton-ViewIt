package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.dao.ProductFacadeLocal;

/**
 *
 * @author Patri Navarro
 */
@WebServlet(name = "BarController", urlPatterns = {"/bar"})
public class BarController extends HttpServlet {
    
    @EJB
    private ProductFacadeLocal productFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             response.setContentType("application/json");
        
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsString(productFacade.findAll());
            out.print(objectMapper.writeValueAsString(productFacade.findAll()));
            //out.print("Hello Bar controller");
            out.close();
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
