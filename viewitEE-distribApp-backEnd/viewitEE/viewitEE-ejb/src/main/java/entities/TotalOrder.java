package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name = "orders")
public class TotalOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "order_id")
    private Long orderId;
    
    @JoinColumn(name="user_id")
    @ManyToOne
    private User user;
    /*
    @OneToMany(cascade= CascadeType.REMOVE )
    @JoinColumn(name = "order_detail_id", referencedColumnName = "order_detail_id")
    private List<OrderDetail> orderDetails;
    */

    @Column (name = "created_date")
    @Temporal(TemporalType.DATE)
    private Calendar createdDate;


    @Column (name = "total")
    private double total;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
/*
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
*/
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
            
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

        public Calendar getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Calendar createdDate) {
        this.createdDate = createdDate;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the orderId fields are not set
        if (!(object instanceof TotalOrder)) {
            return false;
        }
        TotalOrder other = (TotalOrder) object;
        return !((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId)));
    }

    @Override
    public String toString() {
        return "entities.Order[ id=" + orderId + " ]";
    }
    
}
