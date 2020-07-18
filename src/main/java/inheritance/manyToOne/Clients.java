//package inheritance.manyToOne;
//
//import javax.validation.constraints.NotNull;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "clients")
//public class Clients {
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(generator = "ID_GENERATOR")
//    protected Long id;
//
//
//    @NotNull
//    @Column(nullable = false)
//    protected String clientname;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "default_billing")
//    protected BillingDetails defaultBilling;
//
//    public Clients(){}
//    public Clients(String username) {
//        this.clientname = username;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getUsername() {
//        return clientname;
//    }
//
//    public void setUsername(String username) {
//        this.clientname = username;
//    }
//
//    public BillingDetails getDefaultBilling() {
//        return defaultBilling;
//    }
//
//    public void setDefaultBilling(BillingDetails defaultBilling) {
//        this.defaultBilling = defaultBilling;
//    }
//
//
//
//}
