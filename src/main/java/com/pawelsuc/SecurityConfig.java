package com.pawelsuc;

import com.pawelsuc.component.CustomDaoAuthenticationProvider;
import com.pawelsuc.service.impl.JpaUserDetailsService;
import org.hibernate.metamodel.model.domain.ManagedDomainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity(debug = false)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    JpaUserDetailsService userDetailsService;

    @Autowired
    CustomDaoAuthenticationProvider authenticationProvider;

    @Autowired
    public SecurityConfig (JpaUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;

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
                .antMatchers("/sign_up").permitAll()
                .antMatchers("/confirm_email").permitAll()
                .antMatchers("/test").permitAll()
                .antMatchers("/admin_panel").hasAuthority("ADMIN")
                .anyRequest().hasAuthority("USER")
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
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
