//package associations.onetomany.bidirectional;
//
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
//import java.math.BigDecimal;
//
//@Entity
//public class Offer {
//
//    @Id
//    @GeneratedValue(generator = "ID_GENERATOR")
//    protected Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "PRODUCT_ID", nullable = false)
//    protected Product product;
//
//
//    @NotNull
//    protected BigDecimal quantity;
//
//    public Offer() {
//    }
//
//    public Offer(BigDecimal quantity, Product product) {
//        this.quantity = quantity;
//        this.product = product;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public BigDecimal getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(BigDecimal quantity) {
//        this.quantity = quantity;
//    }
//
//}
