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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Console> platformsList;


    public VideoGame(String name, String developer, Date releasedDate, String genre, Double unitsSold, String gameModes, List<Console> platformsList) {
        this.name = name;
        this.developer = developer;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.unitsSold = unitsSold;
        this.gameModes = gameModes;
        this.platformsList = platformsList;
    }

    public VideoGame(String name, String developer, Date releasedDate, String genre, Double unitsSold, String gameModes) {
        this.name = name;
        this.developer = developer;
        this.releasedDate = releasedDate;
        this.genre = genre;
        this.unitsSold = unitsSold;
        this.gameModes = gameModes;
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

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developer='" + developer + '\'' +
                ", releasedDate=" + releasedDate +
                ", genre='" + genre + '\'' +
                ", unitsSold=" + unitsSold +
                ", gameModes='" + gameModes + '\'' +
                ", platformsList=" + platformsList +
                '}';
    }
}
