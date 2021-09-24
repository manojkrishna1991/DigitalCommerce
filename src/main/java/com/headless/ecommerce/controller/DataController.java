package com.headless.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.headless.ecommerce.consumingrest.Quote;
import com.headless.ecommerce.domain.UrlFacts;
import com.headless.ecommerce.service.DataUrlFactsService;

import reactor.core.publisher.Mono;

@RestController
public class DataController {

    @Autowired
    private DataUrlFactsService dataUrlFactsService;
    @GetMapping("/quotes")
    public Mono<Quote> getUrlFacts() {
        return dataUrlFactsService.getUrlsFacts();
    }

}
