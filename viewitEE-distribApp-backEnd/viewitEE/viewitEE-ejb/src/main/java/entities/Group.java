package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String USERS_GROUP = "users"; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "email")
    private String email;
    @Column (name = "groupname")
    private String groupname;
    
    public Group(){}

    public Group(String email, String groupname) {
        this.email = email;
        this.groupname = groupname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the email fields are not set
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public java.lang.String toString() {
        return "entities.Group[ id=" + email + " ]";
    }
    
}
