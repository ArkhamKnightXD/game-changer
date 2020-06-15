package arkham.knight.gamestop.services;
import arkham.knight.gamestop.models.Rol;
import arkham.knight.gamestop.models.User;
import arkham.knight.gamestop.repositories.RolRepository;
import arkham.knight.gamestop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    public void createAdminUser(){

        List<Rol> rolList = new ArrayList<>();

        Rol rolUser = new Rol();

        rolUser.setRole("ROLE_USER");

        rolRepository.save(rolUser);

        Rol rolAdmin = new Rol("ROLE_ADMIN");

        rolRepository.save(rolAdmin);

        rolList.add(rolUser);
        rolList.add(rolAdmin);

        User adminUser = new User("admin",bCryptPasswordEncoder.encode("1234"),true,"arkham.jpg",rolList);

        userRepository.save(adminUser);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<GrantedAuthority> rolList = new ArrayList<>();

        User userAdminToFind = userRepository.findUserByUsername(username);


        for (Rol roles :userAdminToFind.getRolList()) {

            rolList.add(new SimpleGrantedAuthority(roles.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(rolList);

        return new org.springframework.security.core.userdetails.User(userAdminToFind.getUsername(),userAdminToFind.getPassword(), userAdminToFind.isAdmin(), true, true, true, grantedAuthorities);
    }
}
