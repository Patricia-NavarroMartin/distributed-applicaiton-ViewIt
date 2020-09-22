package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "users")
@NamedQueries({
    @NamedQuery(
        name="getUserEmail",
        query="SELECT u.userId FROM User u WHERE u.email = :email"
    ),
    @NamedQuery(
        name="getUserPassword",
        query="SELECT u.password FROM User u WHERE u.email = :email"
    ),
    @NamedQuery(
        name="getUserId",
        query="SELECT u.userId FROM User u WHERE u.email = :email"
    )
})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    /*
    It relies on an auto-incremented database column and lets the database 
    generate a new value with each insert operation.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long userId;
    
    @Column (name = "username")
    private String username;
    
    @Column (name = "email")
    private String email;
    
    @Column (name = "password")
    private String password;
    /*
    @OneToMany
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<TotalOrder> totalOrders;
*/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getEmail() {
        return email;
    }
/*
    public List<TotalOrder> getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(List<TotalOrder> totalOrders) {
        this.totalOrders = totalOrders;
    }*/

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the userId fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        return !((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId)));
    }

    @Override
    public String toString() {
        return "entities.User[ id=" + userId + " ]";
    }
    
}
