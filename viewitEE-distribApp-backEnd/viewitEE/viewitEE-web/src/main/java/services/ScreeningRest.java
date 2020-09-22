package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Movie;
import entities.Screening;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import sessionbeans.dao.ScreeningFacadeLocal;
import static sessionbeans.singleton.ScreeningsCache.*;
import utils.CalendarConverterLocal;

@Path("/screenings")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ScreeningRest {
    @Context 
    private UriInfo uriInfo;
    @PersistenceContext (unitName = "com.patrinav_viewitEE-ejb_ejb_1.0.0PU")
    private EntityManager em;
    @EJB
    private ScreeningFacadeLocal screeningFacade;
    @EJB
    private CalendarConverterLocal calendarConverter;
    /*
    @EJB
    private ScreeningsCache billboardCache;*/
    
    @GET
    public List<Screening> getAllScreenings(){
        return screeningFacade.findAll();
    }
    
    /*
    @GET
    @Path("/{id}")
    public List<Screening> getScreening(@PathParam("id") Long screeningId){
        System.out.println("Received input parameter:" + screeningId);
        return screeningFacade.getScreenings(screeningId);
    }
    */
    
    @GET
    @Path("/{movieId}")
    public List<Screening> getScreening(@PathParam("movieId") Long movieId){
        System.out.println("Received input parameter:" + movieId);
        return screeningFacade.getScreenings(movieId);
    }
    
    @GET
    @Path("/{movieId}/{date}")
    public List<Screening> getScreening(@PathParam("movieId") Long movieId, 
                                        @PathParam("date") String sdate) throws ParseException{
        System.out.println("Received input parameter:" + movieId + " and " + sdate);
        Calendar date_calendar = calendarConverter.stringToCalendar(sdate,"yyyy-MM-dd");
        return screeningFacade.getScreenings(movieId,date_calendar);
    }
    
    @GET
    @Path("/billboard/{date}")
    public List<Movie> getBillboardByDate(@PathParam("date") String sdate) throws ParseException{
        Calendar date_calendar = calendarConverter.stringToCalendar(sdate,"yyyy-MM-dd");
        return screeningFacade.getScreeningMovies(date_calendar);
    }
    
    @GET
    @Path("/billboard/movie/{movieId}")
    public Movie getCurrentBillboardMovie(@PathParam("movieId") Long movieId){
        return getSingleCachedMovie(movieId);
    }
    
    @GET
    @Path("/billboard/movie/{movieId}/screenings")
    public String getCurrentBillboardMovieScreenings(@PathParam("movieId") Long movieId) throws JsonProcessingException{
        List<String> sscreenings = new ArrayList<>();
        List<Calendar> screenings = getSingleCachedMovieScreenings(movieId);
        screenings.stream()
                .forEach(c -> {
                    sscreenings.add(calendarConverter.calendarToString(c, "HH:mm"));
                });
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(sscreenings);
    }
    
    @GET
    @Path("/billboard")
    public List<Movie> getCurrentBillboard(){
        return getMoviesCache();
    }
    
    
    
}
