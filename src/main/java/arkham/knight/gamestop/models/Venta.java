package arkham.knight.gamestop.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Venta implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date soldDate;
    private int total;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Console> consoleListToSell;

    @ManyToMany(mappedBy = "platformsList")
    private List<VideoGame> videoGameListToSell;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Client buyer;




    public Venta() {
    }



}
