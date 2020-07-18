package associations.manytomany.linkentity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CATEGORY_PRODUCT")
@org.hibernate.annotations.Immutable
public class CategorizedProduct {

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "CATEGORY_ID")
        protected Long categoryId;

        @Column(name = "PRODUCT_ID")
        protected Long productId;

        public Id() {
        }

        public Id(Long categoryId, Long productId) {
            this.categoryId = categoryId;
            this.productId = productId;
        }

        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.categoryId.equals(that.categoryId)
                    && this.productId.equals(that.productId);
            }
            return false;
        }

        public int hashCode() {
            return categoryId.hashCode() + productId.hashCode();
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    @Column(updatable = false)
    @NotNull
    protected String addedBy;

    @Column(updatable = false)
    @NotNull
    protected Date addedOn = new Date();

    @ManyToOne
    @JoinColumn(
        name = "CATEGORY_ID",
        insertable = false, updatable = false)
    protected Category category;

    @ManyToOne
    @JoinColumn(
        name = "PRODUCT_ID",
        insertable = false, updatable = false)
    protected Product product;


    public CategorizedProduct() {
    }

    public CategorizedProduct(String addedByUsername,
                              Category category,
                              Product product) {

        // Set fields
        this.addedBy = addedByUsername;
        this.category = category;
        this.product = product;

        // Set identifier values
        this.id.categoryId = category.getId();
        this.id.productId = product.getId();

        // Guarantee referential integrity if made bidirectional
        category.getCategorizedProducts().add(this);
        product.getCategorizedProducts().add(this);
    }

    public Id getId() {
        return id;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public Category getCategory() {
        return category;
    }

    public Product getProduct() {
        return product;
    }

}
