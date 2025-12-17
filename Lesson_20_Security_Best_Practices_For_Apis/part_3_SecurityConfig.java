import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/admin/**").hasRole("ADMIN")     // Admin access only
                .antMatchers("/api/users/**").hasAnyRole("USER", "ADMIN") // User and Admin access
                .anyRequest().authenticated() // Other requests require authentication
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Stateless session
    }
}
