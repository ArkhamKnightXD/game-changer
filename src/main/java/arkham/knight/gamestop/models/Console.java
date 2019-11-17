package arkham.knight.gamestop.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Console implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String developer;
    private String consoleType;
    private int generation;
    private Date releasedDate;
    private Date discontinuedDate;
    private int lifespan;
    private float sellPrice;
    private Double unitsSold;
    private String image;
    private int stock;

    @ManyToMany(mappedBy = "platformsList")
    private List<VideoGame> videoGameList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Console predecessor;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Console successor;


    public Console(String name, String developer, String consoleType, int generation, Date releasedDate, Date discontinuedDate, int lifespan, float sellPrice, Double unitsSold, String image, int stock, List<VideoGame> videoGameList, Console predecessor, Console successor) {
        this.name = name;
        this.developer = developer;
        this.consoleType = consoleType;
        this.generation = generation;
        this.releasedDate = releasedDate;
        this.discontinuedDate = discontinuedDate;
        this.lifespan = lifespan;
        this.sellPrice = sellPrice;
        this.unitsSold = unitsSold;
        this.image = image;
        this.stock = stock;
        this.videoGameList = videoGameList;
        this.predecessor = predecessor;
        this.successor = successor;
    }

    public Console(String name, String developer, String consoleType, int generation, Date releasedDate, Date discontinuedDate, int lifespan, float sellPrice, Double unitsSold, String image, int stock) {
        this.name = name;
        this.developer = developer;
        this.consoleType = consoleType;
        this.generation = generation;
        this.releasedDate = releasedDate;
        this.discontinuedDate = discontinuedDate;
        this.lifespan = lifespan;
        this.sellPrice = sellPrice;
        this.unitsSold = unitsSold;
        this.image = image;
        this.stock = stock;
    }

    public Console() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getConsoleType() {
        return consoleType;
    }

    public void setConsoleType(String consoleType) {
        this.consoleType = consoleType;
    }

    public int getGeneration() { return generation; }

    public void setGeneration(int generation) { this.generation = generation; }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public Date getDiscontinuedDate() {
        return discontinuedDate;
    }

    public void setDiscontinuedDate(Date discontinuedDate) {
        this.discontinuedDate = discontinuedDate;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public Double getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Double unitsSold) {
        this.unitsSold = unitsSold;
    }

    public float getSellPrice() { return sellPrice; }

    public void setSellPrice(float sellPrice) { this.sellPrice = sellPrice; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public List<VideoGame> getVideoGameList() {
        return videoGameList;
    }

    public void setVideoGameList(List<VideoGame> videoGameList) {
        this.videoGameList = videoGameList;
    }

    public Console getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Console predecessor) {
        this.predecessor = predecessor;
    }

    public Console getSuccessor() {
        return successor;
    }

    public void setSuccessor(Console successor) {
        this.successor = successor;
    }
}
