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
                        // 1. Permitir ver la Home, el Login, los recursos (css/js) y las IMÁGENES
                        .requestMatchers("/", "/home", "/index", "/login", "/css/**", "/js/**", "/images/**").permitAll()

                        // 2. IMPORTANTE: Permitir ver el detalle del producto (ajustá la ruta a la tuya)
                        .requestMatchers("/producto/**").permitAll()

                        // 3. Todo lo demás (como /admin/...) requiere estar logueado
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