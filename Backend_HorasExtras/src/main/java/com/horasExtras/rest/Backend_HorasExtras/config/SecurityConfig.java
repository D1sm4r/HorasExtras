package com.horasExtras.rest.Backend_HorasExtras.config;

import com.horasExtras.rest.Backend_HorasExtras.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //para decirle a spring que es una configuracion
@EnableWebSecurity // para habilitar la seguridad web
@EnableMethodSecurity // para utilizar configuracion de spring con anotaciones(opcional)
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(@Lazy UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/css/**", "/js/**", "/img/**", "/AdminLTE-3.2.0/**", "/webjars/**", "/static/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/GestorHorasExtras/index").permitAll()
                        .requestMatchers("/GestorHorasExtras/loginEmpleado").permitAll()
                        .requestMatchers("/GestorHorasExtras/loginAdmin").permitAll()
                        .requestMatchers("/GestorHorasExtras/loginSupervisor").permitAll()
                        .requestMatchers("/GestorHorasExtras/empleado").hasRole("EMPLEADO")
                        .requestMatchers("/GestorHorasExtras/admin_usuarios").hasRole("ADMIN")
                        .requestMatchers("/GestorHorasExtras/admin_proyectos").hasRole("ADMIN")
                        .requestMatchers("/GestorHorasExtras/supervisor").hasRole("SUPERVISOR")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/GestorHorasExtras/index")
                        .invalidateHttpSession(true)
                        .deleteCookies("hola")
                );

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
