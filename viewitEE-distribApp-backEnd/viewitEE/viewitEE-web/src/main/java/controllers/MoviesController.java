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
import sessionbeans.dao.MovieFacadeLocal;

@WebServlet(name = "MoviesController", 
        urlPatterns = {"/moviesS"})
public class MoviesController extends HttpServlet {


    @EJB
    private MovieFacadeLocal movieFacade;
    
    /*
    This information is rarely modified, so it makes more sense to perform the 
    query only once after the application has been deployed, and store the data 
    in an application-scoped attribute. This is accomplished by adding this code
    in the init method by placing the reference in the ServletContext. This means
    that the reference exists in a scope that is application-wide
    */
    
    @Override
    public void init() throws ServletException {
        //store the movie list in the servlet context
        getServletContext().setAttribute("movies", movieFacade.findAll());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsString(movieFacade.findAll());
            out.print(objectMapper.writeValueAsString(movieFacade.findAll()));
            //out.print("Hello Movies controller");
            //objectMapper.writeValueAsString(this.getServletContext().getAttribute("movies"));
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

