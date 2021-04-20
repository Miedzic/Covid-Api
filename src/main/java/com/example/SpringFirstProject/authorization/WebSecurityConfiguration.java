package com.example.SpringFirstProject.authorization;

import com.example.SpringFirstProject.authorization.UserServiceDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
 class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private UserServiceDetailsImpl userServiceDetails;

    public WebSecurityConfiguration(UserServiceDetailsImpl userServiceDetails) {
        this.userServiceDetails = userServiceDetails;
    }
//7 tutaj ustalamy które podstrony wymagają logowania a które nie
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http
                .authorizeRequests()
                //te nie wymagają logowania, pod nimi jest permitAll()
                .antMatchers("/","/console","/register","/statistics","/api/countries","/api/global","/getCountryDetails","/createCountry","/updateCountry","/deleteCountry")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();

    }
    //tutaj wybieramy który serwis odpowiada za porównanie danych w formularzu z naszymi użytkownikami
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userServiceDetails);
    }
    //tutaj wybieramy jakim algorytmem kodujemy hasła
    @Bean
    public PasswordEncoder buildEncoder(){
        return new BCryptPasswordEncoder();
    }


}
