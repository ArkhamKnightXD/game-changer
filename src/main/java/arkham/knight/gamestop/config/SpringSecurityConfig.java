package arkham.knight.gamestop.config;
import arkham.knight.gamestop.services.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityServices securityServices;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .userDetailsService(securityServices)
                .passwordEncoder(bCryptPasswordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
                .authorizeRequests()

                .antMatchers("/","/css/**", "/js/**").permitAll()
                //.antMatchers("/users/**").hasAnyRole("ADMIN")
                //.antMatchers("/clients/**").hasAnyRole("ADMIN", "USER")
                //.antMatchers("/sales/**").hasAnyRole("ADMIN")
                //.antMatchers("/admin/**").hasAnyRole("ADMIN")
                //.antMatchers("/consoles/**").hasAnyRole("ADMIN", "USER")
                //.antMatchers("/videogames/**").hasAnyRole("ADMIN", "USER")
                //.anyRequest().authenticated() //cualquier llamada debe ser validada

                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
