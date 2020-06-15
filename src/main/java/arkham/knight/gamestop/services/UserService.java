package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Rol;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.repositories.RolRepository;
import arkham.knight.gamestop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;


    public void createUser(User user){

        userRepository.save(user);
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


    public List<Rol> findAllRolesById(List<Long> idRoles){

        return rolRepository.findAllById(idRoles);
    }


    public User findUserByUsername(String username){

        return userRepository.findUserByUsername(username);
    }


    public void deleteUser(Long id){

        userRepository.deleteById(id);
    }


    public void deleteAllUser(){

        userRepository.deleteAll();
    }


    public void deleteAllRoles(){

        rolRepository.deleteAll();
    }
}

