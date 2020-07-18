package associations.onetomany.bidirectional;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    protected String name;

//    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
//    protected Set<Offer> offers = new HashSet<Offer>();

    //Каскадная передача состояния хранения
//    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
//    protected Set<Offer> offers = new HashSet<Offer>();

    //Каскадное удаление всех элементов коллекции
    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    protected Set<Offer> offers = new HashSet<Offer>();

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}