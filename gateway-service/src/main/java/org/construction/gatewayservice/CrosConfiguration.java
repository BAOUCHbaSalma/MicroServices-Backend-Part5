package org.construction.gatewayservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CrosConfiguration {
    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.addAllowedOrigin("http://localhost:4200"); // testPermet uniquement localhost:4200
        corsConfig.addAllowedMethod("*"); // Autorise toutes les méthtetsfgfdghgkghjqgyudeodes (GET, POST, PUT, etc.)
        corsConfig.addAllowedHeader("*"); // Autorise tous les headers
        corsConfig.setAllowCredentials(true); // Permet l'envoi de credentials (si nécessaire)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig); // Applique la config à toutes les routes

        return new CorsWebFilter(source);
    }
}
