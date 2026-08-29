package com.platzi.play.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.play.domain.service.PlatziPlayAiServices;

@RestController
public class HelloControler {

    private final String plataform;
    private final PlatziPlayAiServices aiService;

    public HelloControler(@Value("${spring.application.name}") String plataform,PlatziPlayAiServices aiService){
        this.plataform = plataform;
        this.aiService = aiService;
    }

    @GetMapping("/hello")
    public String hello(){
        return this.aiService.generateGreeting(plataform);
    }
}
