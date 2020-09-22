package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "cinemas")
public class Cinema implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "cinema_id")
    private Long cinemaId;
    
    @Column (name = "name")
    private String name;
    
    @Column (name = "location")
    private String location;
    
    @OneToMany
    @JoinColumn (name = "cinema_id", referencedColumnName = "cinema_id")
    private List<Screening> screenings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Screening> getScreenings() {
        return screenings;
    }

    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings;
    }

    
    public Long getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Long cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cinemaId != null ? cinemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the cinemaId fields are not set
        if (!(object instanceof Cinema)) {
            return false;
        }
        Cinema other = (Cinema) object;
        return !((this.cinemaId == null && other.cinemaId != null) || (this.cinemaId != null && !this.cinemaId.equals(other.cinemaId)));
    }

    @Override
    public String toString() {
        return "entities.Cinema[ id=" + cinemaId + " ]";
    }
    
}
