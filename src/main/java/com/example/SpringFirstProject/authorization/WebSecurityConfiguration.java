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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
        http
                .authorizeRequests()
                .antMatchers("/","/console","/register","/statistics","/api/countries","api/global")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userServiceDetails);
    }
    @Bean
    public PasswordEncoder buildEncoder(){
        return new BCryptPasswordEncoder();
    }


}
