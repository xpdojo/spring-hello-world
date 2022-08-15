package org.xpdojo.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicate;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class HelloRouter {

    private final HelloHandler helloHandler;

    public HelloRouter(HelloHandler helloHandler) {
        this.helloHandler = helloHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> helloRoute() {
        RequestPredicate requestPredicate = RequestPredicates
                .GET("/")
                .and(accept(MediaType.TEXT_PLAIN));

        return route(requestPredicate, helloHandler::hello);
    }
}
