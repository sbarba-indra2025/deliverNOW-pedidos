package com.delivernow.back1_creacion_pedidos;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // permite solicitudes CORS desde cualquier origen
        registry.addMapping("/**")  // aplica CORS a todas las rutas de la API
            .allowedOrigins("*")     // permite todos los orígenes
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // métodos HTTP permitidos
            .allowedHeaders("*")     // permite cualquier cabecera
            .allowCredentials(true); // permite el envío de cookies y credenciales
    }
}
