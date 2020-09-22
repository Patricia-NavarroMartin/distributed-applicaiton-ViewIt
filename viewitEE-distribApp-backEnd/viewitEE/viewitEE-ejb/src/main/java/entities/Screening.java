/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Patri Navarro
 */
@Entity
@NamedQueries({
    @NamedQuery(
        name="getScreeningsForMovie",
        query="SELECT s FROM Screening s WHERE s.movie.movieId = :movieId "
    ),
    @NamedQuery(
        name="getScreeningsForMovieAndDate",
        query="SELECT s FROM Screening s WHERE s.movie.movieId = :movieId AND s.screeningDate = :date"
    ),
    @NamedQuery(
        name="getScreeningMovies",
        query="SELECT s.movie FROM Screening s WHERE s.screeningDate = :date GROUP BY s.movie.movieId"
    ),
    @NamedQuery(
        name="getScreeningsByDate",
        query="SELECT s FROM Screening s WHERE s.screeningDate = :date"
    )
})
@Table (name = "screenings")
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "screening_id")
    private Long screeningId;
    
    @ManyToOne
    @JoinColumn (name = "movie_id")
    private Movie movie;
    
    @Column (name = "screening_date")
    @Temporal (TemporalType.DATE)
    private Calendar screeningDate;
    
    @Column (name = "screening_time")
    @Temporal (TemporalType.TIME)
    private Calendar screeningTime;

    public Long getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Calendar getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Calendar screeningDate) {
        this.screeningDate = screeningDate;
    }

    public Calendar getScreeningTime() {
        return screeningTime;
    }

    public void setScreeningTime(Calendar screeningTime) {
        this.screeningTime = screeningTime;
    }
    
    
}
