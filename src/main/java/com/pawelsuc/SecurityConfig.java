package com.pawelsuc;

import com.pawelsuc.component.CustomDaoAuthenticationProvider;
import com.pawelsuc.service.impl.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    JpaUserDetailsService userDetailsService;
    CustomDaoAuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityConfig (JpaUserDetailsService userDetailsService, CustomDaoAuthenticationProvider authenticationProvider) {
        this.userDetailsService = userDetailsService;
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/admin_panel").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("foo")
                .passwordParameter("bar")
                .defaultSuccessUrl("/user_panel", true)
                .and()
                .logout()
                .logoutUrl("/user_logout")
                .logoutSuccessUrl("/login?logout")
                .deleteCookies("cookies");
    }
}
