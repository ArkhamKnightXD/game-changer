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
    private long unitsSold;
    private String bestSellingGame;
    private String predecessor;
    private String  successor;
    private String backwardCompatibility;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<VideoGame> videoGameList;


    public Console(String name, String developer, String consoleType, String generation, Date releasedDate, Date discontinuedDate, int lifespan, long unitsSold, String bestSellingGame, String predecessor, String successor, String backwardCompatibility, List<VideoGame> videoGameList) {
        this.name = name;
        this.developer = developer;
        this.consoleType = consoleType;
        this.generation = generation;
        this.releasedDate = releasedDate;
        this.discontinuedDate = discontinuedDate;
        this.lifespan = lifespan;
        this.unitsSold = unitsSold;
        this.bestSellingGame = bestSellingGame;
        this.predecessor = predecessor;
        this.successor = successor;
        this.backwardCompatibility = backwardCompatibility;
        this.videoGameList = videoGameList;
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

    public long getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(long unitsSold) {
        this.unitsSold = unitsSold;
    }

    public String getBestSellingGame() {
        return bestSellingGame;
    }

    public void setBestSellingGame(String bestSellingGame) {
        this.bestSellingGame = bestSellingGame;
    }

    public String getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(String predecessor) {
        this.predecessor = predecessor;
    }


    public String getSuccessor() {
        return successor;
    }

    public void setSuccessor(String successor) {
        this.successor = successor;
    }

    public String getBackwardCompatibility() {
        return backwardCompatibility;
    }

    public void setBackwardCompatibility(String backwardCompatibility) {
        this.backwardCompatibility = backwardCompatibility;
    }

    public List<VideoGame> getVideoGameList() {
        return videoGameList;
    }

    public void setVideoGameList(List<VideoGame> videoGameList) {
        this.videoGameList = videoGameList;
    }

    @Override
    public String toString() {
        return "Console{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developer='" + developer + '\'' +
                ", consoleType='" + consoleType + '\'' +
                ", generation='" + generation + '\'' +
                ", releasedDate=" + releasedDate +
                ", discontinuedDate=" + discontinuedDate +
                ", lifespan=" + lifespan +
                ", unitsSold=" + unitsSold +
                ", bestSellingGame='" + bestSellingGame + '\'' +
                ", predecessor='" + predecessor + '\'' +
                ", successor='" + successor + '\'' +
                ", backwardCompatibility='" + backwardCompatibility + '\'' +
                '}';
    }
}
