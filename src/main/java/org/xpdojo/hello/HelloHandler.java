package org.xpdojo.hello;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Slf4j
@Component
public class HelloHandler {

    @Value("${server.port}")
    private int port;

    public Mono<ServerResponse> hello(ServerRequest request) {

        log.info("request >>> {}", request);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromValue("port:" + port));
    }
}
