package inheritance.manyToOne;

import javax.validation.constraints.NotNull;

import javax.persistence.*;

@Entity
@Table (name = "CLIENT")

public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;


    @NotNull
    @Column(name = "client_name", nullable = false)
    protected String clientname;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "default_billing")
    protected BillingDetails defaultBilling;

    public Client(){}
    public Client(String username) {
        this.clientname = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return clientname;
    }

    public void setUsername(String username) {
        this.clientname = username;
    }

    public BillingDetails getDefaultBilling() {
        return defaultBilling;
    }

    public void setDefaultBilling(BillingDetails defaultBilling) {
        this.defaultBilling = defaultBilling;
    }



}
