package com.example.footballapp.security.config;

import com.example.footballapp.models.enums.UserType;
import com.example.footballapp.repository.UsersRepository;
import com.example.footballapp.security.filter.CustomAuthFilter;
import com.example.footballapp.security.service.TokenService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsersRepository usersRepository;
    private final JwtConfig jwtConfig;
    private final TokenService tokenService;


    public SecurityConfig(UsersRepository usersRepository, JwtConfig jwtConfig, TokenService tokenService) {
        this.usersRepository = usersRepository;
        this.jwtConfig = jwtConfig;
        this.tokenService = tokenService;
    }

    protected void configure(HttpSecurity http) throws Exception {

        http.cors();

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/logout").permitAll()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/management/**")
                    .hasAnyAuthority(UserType.Type.ADMIN.toString())
                .anyRequest().authenticated();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterAfter(new CustomAuthFilter(jwtConfig,
                        usersRepository,
                        tokenService),
                        BasicAuthenticationFilter.class);

    }

}
