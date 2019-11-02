package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Rol;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.repositories.RolRepository;
import arkham.knight.gamestop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;


    public void createUser(User user){

        userRepository.save(user);

    }


    public void createRole(Rol role){

        rolRepository.save(role);

    }


    public List<User> listAllUsers(){

        return userRepository.findAll();
    }


    public List<Rol> listAllRoles(){

        return rolRepository.findAll();
    }


    public User findUserById(long id){

        return userRepository.findUserById(id);
    }


    public Rol findRoleById(long id){

        return rolRepository.findRolById(id);
    }


    public User findUserByUsername(String username){

        return userRepository.findUserByUsername(username);
    }


    public void deleteUser(User user){

        userRepository.delete(user);
    }

    public void deleteAllUser(){

        userRepository.deleteAll();
    }

    public void deleteAllRoles(){

        rolRepository.deleteAll();
    }

}

