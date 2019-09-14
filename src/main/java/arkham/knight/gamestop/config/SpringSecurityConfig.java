package arkham.knight.gamestop.config;
import arkham.knight.gamestop.services.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class SpringSecurityConfig {

    @Autowired
    private SecurityServices securityServices;


}
