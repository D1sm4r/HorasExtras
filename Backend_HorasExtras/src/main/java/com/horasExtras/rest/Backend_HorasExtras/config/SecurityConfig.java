package com.horasExtras.rest.Backend_HorasExtras.config;

import com.horasExtras.rest.Backend_HorasExtras.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //para decirle a spring que es una configuracion
@EnableWebSecurity // para habilitar la seguridad web
@EnableMethodSecurity // para utilizar configuracion de spring con anotaciones(opcional)
public class SecurityConfig {

    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())//solo para usar usuario y contraseña
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// sessiones sin estado es mejor
                .authorizeHttpRequests(http -> {
                    http.requestMatchers(HttpMethod.GET, "/auth/hello").permitAll();// se da la autorizacion para que todos puedan entrar
                    http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAuthority("READ");// se le pide que tenga autorizacion

                    http.anyRequest().denyAll();//rechaza atodo lo que no se especifique
                    //http.anyRequest().authenticated(); acepta a culquiera que este autenticado
                })
                .build();
    }//pasa por los filtros el HttpSecurity*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())//solo para usar usuario y contraseña
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))// sessiones sin estado es mejor
                .build();
    }//pasa por los filtros el HttpSecurity

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImpl userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


//comentamos el metodod e abajo y lo implementamos en AuthenticationProvaider para que conecte en la base de datos
    /* user detail service local osea que se le asignan los usuarios en memoria y no se conecta en la base de datos
    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> userDetailsList = new ArrayList<>();
        //Lista de usuarios
        userDetailsList.add
                (User.withUsername("Javier")
                .password("1123")
                .roles("ADMIN")
                .authorities("READ", "CREATE")
                .build());
        userDetailsList.add
                (User.withUsername("Haly")
                        .password("2232")
                        .roles("USER")
                        .authorities("READ")
                        .build());

        return new InMemoryUserDetailsManager(userDetailsList );
    }
     */



    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance(); // este de por si no encripta las password es solo para pruebas
        return new BCryptPasswordEncoder(); //Este si encripta las contraseñas
    }

/* Para encriptar la contraseña
    public static void main(String[] args){
        System.out.println(new BCryptPasswordEncoder().encode("1234"));
    }
 */

}
