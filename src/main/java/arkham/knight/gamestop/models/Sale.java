package arkham.knight.gamestop.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Sale implements Serializable {

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


    public Sale(Date soldDate, int total, List<Console> consoleListToSell, List<VideoGame> videoGameListToSell, Client buyer) {
        this.soldDate = soldDate;
        this.total = total;
        this.consoleListToSell = consoleListToSell;
        this.videoGameListToSell = videoGameListToSell;
        this.buyer = buyer;
    }

    public Sale() {
    }


    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(Date soldDate) {
        this.soldDate = soldDate;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Console> getConsoleListToSell() {
        return consoleListToSell;
    }

    public void setConsoleListToSell(List<Console> consoleListToSell) {
        this.consoleListToSell = consoleListToSell;
    }

    public List<VideoGame> getVideoGameListToSell() {
        return videoGameListToSell;
    }

    public void setVideoGameListToSell(List<VideoGame> videoGameListToSell) { this.videoGameListToSell = videoGameListToSell; }

    public Client getBuyer() {
        return buyer;
    }

    public void setBuyer(Client buyer) {
        this.buyer = buyer;
    }
}
