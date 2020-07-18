//package inheritance.manyToOne;
//
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
//@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//
//public abstract class BillingDetails {
//    protected Long id;
//
//    @NotNull
//    protected String owner;
//
//    protected BillingDetails() {
//    }
//
//    protected BillingDetails(String owner) {
//        this.owner = owner;
//    }
//
//    // Use property instead of field access, so calling getId() doesn't initialize a proxy!
//    @Id
//    @GeneratedValue(generator = "ID_GENERATOR")
//    public Long getId() {
//        return id;
//    }
//
//    private void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getOwner() {
//        return owner;
//    }
//
//    public void setOwner(String owner) {
//        this.owner = owner;
//    }
//
//    public void pay(int quantity) {
//        // NOOP
//    }
//}
