package com.fiap.cerveja.config;

import com.fiap.cerveja.security.JwtAutheticationEntryPoint;
import com.fiap.cerveja.security.JwtRequestFilter;
import com.fiap.cerveja.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private JwtUserDetailsService jwtUserDetailsService;
    private PasswordEncoder passwordEncoder;
    private JwtAutheticationEntryPoint jwtAutheticationEntryPoint;
    private JwtRequestFilter jwtRequestFilter;

    public SecurityConfig(JwtUserDetailsService jwtUserDetailsService,
                          PasswordEncoder passwordEncoder,
                          JwtAutheticationEntryPoint jwtAutheticationEntryPoint,
                          JwtRequestFilter jwtRequestFilter) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtAutheticationEntryPoint = jwtAutheticationEntryPoint;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    // Autenticação (401 - Unauthorized)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder);
    }

    // Autorização (403 - Forbidden)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/cervejas").hasRole("GERENTE")
                .antMatchers("/usuarios/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .exceptionHandling().authenticationEntryPoint(jwtAutheticationEntryPoint)
                .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .formLogin().disable();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers(
                        "/v3/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/security",
                        "/swagger-ui/**",
                        "/webjars/**"
                );
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
