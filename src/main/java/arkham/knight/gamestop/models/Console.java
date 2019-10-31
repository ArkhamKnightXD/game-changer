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
    private String generation;
    private Date releasedDate;
    private Date discontinuedDate;
    private int lifespan;
    private Double unitsSold;
    private String image;

    @ManyToMany(mappedBy = "platformsList")
    private List<VideoGame> videoGameList;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Console predecessor;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Console successor;


    public Console(String name, String developer, String consoleType, String generation, Date releasedDate, Date discontinuedDate, int lifespan, Double unitsSold, String image) {
        this.name = name;
        this.developer = developer;
        this.consoleType = consoleType;
        this.generation = generation;
        this.releasedDate = releasedDate;
        this.discontinuedDate = discontinuedDate;
        this.lifespan = lifespan;
        this.unitsSold = unitsSold;
        this.image = image;
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

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

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
