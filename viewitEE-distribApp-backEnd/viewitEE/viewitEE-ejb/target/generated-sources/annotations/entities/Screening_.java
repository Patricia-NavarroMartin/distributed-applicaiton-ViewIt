package entities;

import entities.Movie;
import java.util.Calendar;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-04T16:28:32")
@StaticMetamodel(Screening.class)
public class Screening_ { 

    public static volatile SingularAttribute<Screening, Movie> movie;
    public static volatile SingularAttribute<Screening, Calendar> screeningDate;
    public static volatile SingularAttribute<Screening, Calendar> screeningTime;
    public static volatile SingularAttribute<Screening, Long> screeningId;

}