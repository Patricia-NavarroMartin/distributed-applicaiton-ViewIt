package sessionbeans.singleton;

import entities.Movie;
import entities.Screening;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sessionbeans.dao.ScreeningFacadeLocal;
import static sessionbeans.singleton.TheLogger.getLog;
import utils.CalendarConverterLocal;

@Singleton
@Startup
public class ScreeningsCache {
    
    @EJB
    private ScreeningFacadeLocal screeningFacade;
    
    private static List<Screening> screeningsCache;
   
    @PostConstruct
    void init(){
        resetScreeningsCache();
    }
    
    public static List<Screening> getBillboardCache() {
        return screeningsCache;
    }
    
    @Schedule(second="0", minute="0", hour="0")
    public void resetScreeningsCache(){
       getLog().info("Refreshing screenings cache");
       Calendar today = Calendar.getInstance();
       screeningsCache = screeningFacade.getScreeningsByDate(today);
    }
    
    public static List<Movie> getMoviesCache(){
        return screeningsCache.stream()
                .map(Screening::getMovie)
                .distinct()
                .collect(Collectors.toList());
    }
             
    public static Movie getSingleCachedMovie(Long movieId){
        return getMoviesCache().stream()
                .filter(m -> movieId.equals(m.getMovieId()))
                .findFirst().get();
    }
    
    
    public static List<Calendar> getSingleCachedMovieScreenings(Long movieId){
        return screeningsCache.stream()
                .filter(s -> movieId.equals(s.getMovie().getMovieId()))
                .map(s -> s.getScreeningTime())
                .collect(Collectors.toList());
    }
    
       
}
