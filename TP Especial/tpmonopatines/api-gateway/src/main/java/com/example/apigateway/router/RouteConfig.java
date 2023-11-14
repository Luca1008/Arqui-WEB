package com.example.apigateway.router;

import com.example.apigateway.security.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

        @Bean
        public RouteLocator routes(RouteLocatorBuilder builder, AuthenticationFilter authFilter) {
                return builder.routes()
                                //Ruteo Autenticacion:
                                .route("lll", r -> r.path("/api/authenticate")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8081"))
                                .route("auth-service", r -> r.path("/api/register")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8081"))
                                // Ruteo Administrador:
                                .route("admin-base", r -> r.path("/administrador/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8081"))
                                // ruteo mantenimienoto:
                                .route("mantenimiento-base", r -> r.path("/mantenimiento/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                //Ruteo Seguimiento:
                                //-Ruteo Monopatin:
                                .route("monopatin-base", r -> r.path("/monopatin/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8083"))
                                //-Ruteo Paradas:
                                .route("parada-base", r -> r.path("/parada/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8083"))
                                //-Ruteo Viaje:
                                .route("viaje-base", r -> r.path("/viaje/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8083"))
                                //Ruteo Usuario
                                //-Ruteo Usuario:
                                .route("Usuario-Base", r -> r.path("/usuarios/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8084"))
                                //-Ruteo Cuenta:
                                 .route("cuenta-Base", r -> r.path("/cuentas/**")
                                                // .filters(f -> f.filter(
                                                                // authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8084"))
                                .build();
        }

}
