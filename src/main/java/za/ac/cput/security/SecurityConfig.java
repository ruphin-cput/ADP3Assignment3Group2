package za.ac.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*  SecurityConfig.java
    Security on endpoints
    Authors: Group02 (Bhixa, Bitota, Bolonda, Boltman, Booysen, Burger)
    Date: 10 October 2021
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("librarianA")
                .password(encoder().encode("librarianA"))
                .roles("ADMIN")
                .and()
                .withUser("studentA")
                .password(encoder().encode("studentA"))
                .roles("USER");
    }
    /*
       These antMatchers should match the methods in the Controller for the entity -->Example: user/getAll in UserController.java
       and only allow suitable authorization for CRUD -->Example: the users (students) would be able to find books but not add,
       update or delete books in the library system (those tasks are for the librarians)
       Create --> POST
       Read --> GET
       Update --> PUT
       Delete --> DELETE
    */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"**/user/create").hasRole("ADMIN") // Only the ADMINs can create new users
                .antMatchers(HttpMethod.GET, "**/user/read/{id}").hasRole("ADMIN")// Only the ADMINs would have to view specific users
                .antMatchers(HttpMethod.PUT,"**/user/update").hasRole("ADMIN") // Only ADMINs would update users
                .antMatchers(HttpMethod.DELETE,"**/user/delete/{id}").hasRole("ADMIN") // Only ADMINs would delete users
                .antMatchers(HttpMethod.GET, "**/user/getAll").hasRole("ADMIN") // Only the ADMINs would have to view all users
                .and()
                .csrf().disable()
                .formLogin().disable(); // This Disable is for if you dont use login forms for usernames and passwords
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
//Author details:
//Adriaan Burger(219014868)