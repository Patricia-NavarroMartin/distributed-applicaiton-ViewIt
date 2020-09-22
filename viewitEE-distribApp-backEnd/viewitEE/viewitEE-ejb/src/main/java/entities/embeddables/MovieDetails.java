package entities.embeddables;

import enumerations.Genre;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class MovieDetails implements Serializable {
    @Enumerated(EnumType.STRING)
    @Column (name = "genre")
    private Genre genre;
    @Column (name = "duration")
    private Integer duration;
    @Column (name = "sinopsis", length = 2000)
    private String sinopsis;

    public MovieDetails() {
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }    
}
