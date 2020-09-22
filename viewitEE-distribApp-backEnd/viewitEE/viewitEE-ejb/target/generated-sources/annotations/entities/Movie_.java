package entities;

import entities.embeddables.MovieDetails;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T16:28:32")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile SingularAttribute<Movie, String> trailer;
    public static volatile SingularAttribute<Movie, String> image;
    public static volatile SingularAttribute<Movie, MovieDetails> movieDetails;
    public static volatile SingularAttribute<Movie, Long> movieId;
    public static volatile SingularAttribute<Movie, String> title;

}