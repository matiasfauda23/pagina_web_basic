package com.matias.portfolioweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration      // Le dice a Spring que aca hay reglas de configuracion
@EnableWebSecurity  // Activamos la seguridad web
public class SegurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // 1. Regla publica:
                        // Permitir entrar a "/" (inicio) y a "/css", "/js"
                        // .permitAll() significa "Entrada libre"
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()

                        // 2. Regla privada
                        // Cualquier otra URL (/nuevo, /borrar, /editar) requiere estar logueado
                        .anyRequest().authenticated()
                )
                // 3. Activar login
                // Usamos el formulario por defecto de Spring
                .formLogin(Customizer.withDefaults())

                // 4. Activar logout
                // Permitir que cualquiera pueda cerrar sesión
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
}