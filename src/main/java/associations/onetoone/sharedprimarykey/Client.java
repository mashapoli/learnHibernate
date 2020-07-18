package associations.onetoone.sharedprimarykey;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    protected Long id;


    protected String clientname;

    @OneToOne(
        fetch = FetchType.LAZY
    )
    @PrimaryKeyJoinColumn
    protected Location shippingLocation;


    protected Client() {
    }

    public Client(Long id, String clientname) {
        this.id = id;
        this.clientname = clientname;
    }

    public Long getId() {
        return id;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String username) {
        this.clientname = clientname;
    }

    public Location getShippingLocation() {
        return shippingLocation;
    }

    public void setShippingLocation(Location shippingLocation) {
        this.shippingLocation = shippingLocation;
    }

}
