package com.moviefactsworkshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
    @GetMapping("/")
    public String index(){
        return "Hello user. This is an application that provides information about movies.";
    }

    @GetMapping("/getFirst")
    public String getFirstTitle(String movieTitle){
        return movieTitle;
    }
}
