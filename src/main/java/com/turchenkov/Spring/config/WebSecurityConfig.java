package com.turchenkov.Spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/reports").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll().and().logout().permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/h2/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(admin);
    }
}
