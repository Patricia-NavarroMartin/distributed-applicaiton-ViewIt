package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "order_details")
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "order_detail_id")
    private Long orderDetailId;
    
    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;
    
    @Column (name = "quantity")
    private int quantity;
    
    @Column (name = "order_detail_price")
    private double orderDetailPrice;
    
    @ManyToOne
    @JoinColumn (name = "order_id")
    private TotalOrder order;
    

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getOrderDetailPrice() {
        return orderDetailPrice;
    }

    public void setOrderDetailPrice(Double orderDetailPrice) {
        this.orderDetailPrice = orderDetailPrice;
    }    
    
    public TotalOrder getOrder() {
        return order;
    }

    public void setOrder(TotalOrder order) {
        this.order = order;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailId != null ? orderDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the orderDetailId fields are not set
        if (!(object instanceof OrderDetail)) {
            return false;
        }
        OrderDetail other = (OrderDetail) object;
        return !((this.orderDetailId == null && other.orderDetailId != null) || (this.orderDetailId != null && !this.orderDetailId.equals(other.orderDetailId)));
    }

    @Override
    public String toString() {
        return "entities.OrderDetail[ id=" + orderDetailId + " ]";
    }
    
}
