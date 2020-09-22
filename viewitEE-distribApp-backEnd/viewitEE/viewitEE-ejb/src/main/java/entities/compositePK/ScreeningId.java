
package entities.compositePK;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class ScreeningId implements Serializable {
    private Long cinemaId;
    private Long movieId;

    public ScreeningId() {
    }

    public ScreeningId(Long cinemaId, Long movieId) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); 
    }
    
    
}
