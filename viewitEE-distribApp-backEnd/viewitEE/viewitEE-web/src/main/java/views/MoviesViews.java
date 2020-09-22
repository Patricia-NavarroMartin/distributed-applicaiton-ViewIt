package views;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletResponse;
import sessionbeans.dao.MovieFacadeLocal;

public class MoviesViews {
    
    @EJB
    private MovieFacadeLocal movieFacade;
    
    public void getMovies(HttpServletResponse response){
        PrintWriter out;
        try {
            out = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsString(movieFacade.findAll());
            out.print(objectMapper.writeValueAsString(movieFacade.findAll()));
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(MoviesViews.class.getName()).log(Level.SEVERE, null, ex);
        }
        //out.print("Hello billboard (all movies found)");
    }
    
    public void getMovie(HttpServletResponse response){
        PrintWriter out;
        try {
            out = response.getWriter();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValueAsString(movieFacade.findAll());
            out.print(objectMapper.writeValueAsString(movieFacade.findAll()));
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(MoviesViews.class.getName()).log(Level.SEVERE, null, ex);
        }
        //out.print("Hello billboard (all movies found)");
    }
    
}
