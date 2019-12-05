package arkham.knight.gamestop.models;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean admin;
    private String image;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Rol> rolList;


    public User(String username, String password, boolean admin, String image, List<Rol> rolList) {
        this.username = username;
        this.password = password;
        this.admin = admin;
        this.image = image;
        this.rolList = rolList;
    }

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() { return admin; }

    public void setAdmin(boolean admin) { this.admin = admin; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }
}
