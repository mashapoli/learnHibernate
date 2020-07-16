import javax.persistence.*;

@Entity
@Table(name = "banks_table")
public class Bank {
    @Id
    @Column (name = "id")
    @GeneratedValue (generator = "inc")
    private Long id;

    public Bank() {
    }

    @Column(name = "text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
