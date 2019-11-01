package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;


    public void createUser(User console){

        userRepository.save(console);

    }


    public List<User> listAllUsers(){

        return userRepository.findAll();
    }


    public User findUserById(long id){

        return userRepository.findUserById(id);
    }


    public User findUserByUsername(String username){

        return userRepository.findUserByUsername(username);
    }


    public void deleteUser(User user){

        userRepository.delete(user);
    }
}

