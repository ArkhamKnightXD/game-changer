package arkham.knight.gamestop.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private String photo;


    public Client(String name, String lastName, String address, String phone, String email, String photo) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }

    public Client() {
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoto() { return photo; }

    public void setPhoto(String photo) { this.photo = photo; }
}
