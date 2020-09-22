package entities.inherited;

import entities.Product;
import enumerations.EdibleCategory;
import enumerations.ProductSize;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue ("edible")
public class Edible extends Product {

    @Column (name = "product_size")
    @Enumerated (EnumType.STRING)
    private ProductSize productSize;
    
    @Column (name = "category")
    @Enumerated (EnumType.STRING)
    private EdibleCategory category;

    public ProductSize getProductSize() {
        return productSize;
    }

    public void setProductSize(ProductSize productSize) {
        this.productSize = productSize;
    }

    public EdibleCategory getCategory() {
        return category;
    }

    public void setCategory(EdibleCategory category) {
        this.category = category;
    }
    
    
    
}
