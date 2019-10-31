package arkham.knight.gamestop.services;
import arkham.knight.gamestop.repositories.RolRepository;
import arkham.knight.gamestop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityServices  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;
}
