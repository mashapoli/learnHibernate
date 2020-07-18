package associations.manytomany.linkentity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    protected Long id;

    protected String name;

    @OneToMany(mappedBy = "product")
    protected Set<CategorizedProduct> categorizedProducts = new HashSet<CategorizedProduct>();

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

    public Set<CategorizedProduct> getCategorizedProducts() {
        return categorizedProducts;
    }

}
