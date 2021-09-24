package com.headless.ecommerce.configuration.rest;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class RestClientConfig {

    public <I, O> Mono<O> get(String uri, final Class<O> responseType) {
        return WebClient.create()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(responseType);
    }



}
