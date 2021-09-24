package com.headless.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.headless.ecommerce.configuration.rest.RestClientConfig;
import com.headless.ecommerce.consumingrest.Quote;
import com.headless.ecommerce.domain.UrlFacts;
import com.headless.ecommerce.exception.NotFoundException;

import reactor.core.publisher.Mono;

@Service
public class DataUrlFactsService {
    @Autowired
    private RestClientConfig restClientConfig;
    
    public Mono<Quote> getUrlsFacts() {
        return restClientConfig.get("https://quoters.apps.pcfone.io/api/random", Quote.class).doOnSuccess(error ->  {
            throw new NotFoundException();
        });
    }
}
