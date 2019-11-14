package arkham.knight.gamestop.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class VideoGame implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String developer;
    private Date releasedDate;
    private String genre;
    private Double unitsSold;
    private String gameModes;
    private float rating;
    private float sellPrice;
    private String image;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Console> platformsList;


    public VideoGame(String name, String developer, Date releasedDate, String genre, Double unitsSold, String gameModes, float rating, float sellPrice, String image, List<Console> platformsList) {
        this.name = name;
        this.developer = developer;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.unitsSold = unitsSold;
        this.gameModes = gameModes;
        this.rating = rating;
        this.sellPrice = sellPrice;
        this.image = image;
        this.platformsList = platformsList;
    }

    public VideoGame() {
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

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Double unitsSold) {
        this.unitsSold = unitsSold;
    }

    public String getGameModes() {
        return gameModes;
    }

    public void setGameModes(String gameModes) {
        this.gameModes = gameModes;
    }

    public List<Console> getPlatformsList() {
        return platformsList;
    }

    public void setPlatformsList(List<Console> platformsList) {
        this.platformsList = platformsList;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getSellPrice() { return sellPrice; }

    public void setSellPrice(float sellPrice) { this.sellPrice = sellPrice; }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
