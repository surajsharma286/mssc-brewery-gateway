package com.sgf.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("google")
@Configuration
public class LocalhostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r-> r.path("/api/v1/beer*","/api/v1/beer/*","/api/v1/beerUpc/*")
                        .uri("http://localhost:8080"))
                .route( r-> r.path("/api/v1/customers/**")
                .uri("http://localhost:8081"))
                .build();
    }
}
