package dev.maneesha.userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //It's a special class where you can define multiple objects (note:- you can use @Component annotation as well, it will work
public class SpringSecurity {

    //http.authorizeHttpRequests(authorize-> authorize.requestMatchers("/auth/logout").authenticated());
    //above line means , only a person who has logged in can view these apis
    //when you start the application, spring will create an object of SecurityFilterChain
    @Bean
    public SecurityFilterChain filteringCriteria(HttpSecurity http) throws Exception {
        //after disabling cors and csrf , it is allowing to signup
        http.cors().disable();
        http.csrf().disable();
        http.authorizeHttpRequests(authorize-> authorize.anyRequest().permitAll());
        //http.authorizeHttpRequests(authorize-> authorize.requestMatchers("/auth/logout").denyAll());
        return http.build();
    }

    //right now we were saving the password as it is
    //now we will save it after encrypting it
    //since BCryptPasswordEncoder does not have any special annotation over the class, so we were unable to autowire it
    //that's why creating bean of it
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
