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
                                .route("lll", r -> r.path("/api/authenticate")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8081"))
                                .route("auth-service", r -> r.path("/api/register")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8081"))
                                .route("micro-a-product", r -> r.path("/api/admin/products/**")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("micro-a-product", r -> r.path("/api/products/**")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-crear", r -> r.path("/api/administrador/")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-findById", r -> r.path("/api/administrador/{id}")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-findAll", r -> r.path("/api/administrador/")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-delete", r -> r.path("/api/administrador/{id}")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-anularCuenta", r -> r.path("/api/administrador/cuenta/anular/{id}")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-viajesAño", r -> r.path("/api/administrador/buscar/year/{year}/viajes/{numViajes}")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-factura", r -> r.path("/api/administrador/CalcularTotal/year/{year}/mesInicio/{mesInicio}/mesFin/{mesFin}")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .route("admin-enFuncionamiento", r -> r.path("/api/administrador/monopatinesEnOperacionOEnMantenimiento")
                                                .filters(f -> f.filter(
                                                                authFilter.apply(new AuthenticationFilter.Config())))
                                                .uri("http://localhost:8082"))
                                .build();
        }

}
