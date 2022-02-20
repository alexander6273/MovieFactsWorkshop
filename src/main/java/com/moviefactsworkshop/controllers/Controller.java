package com.moviefactsworkshop.controllers;

import com.moviefactsworkshop.models.Movie;
import com.moviefactsworkshop.repositories.FileReader;
import com.moviefactsworkshop.services.Services;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller
{
    private Services service = new Services();
    private FileReader fileReader = new FileReader();

    @GetMapping("/")
    public String index(){
        return "Hello user. This is an application that provides information about movies.";
    }

    @GetMapping("/getFirst")
    public String getFirstTitle(){
        return service.getFirstMovieTitle(fileReader.getAllMovies());
    }

    @GetMapping("/getRandom")
    public String getRandomMovieTitle(){
        return service.getRandomTitle(fileReader.getAllMovies());
    }

    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> sortTenRandomMoviesByPop(){
        return service.tenSortedMoviesByPop(fileReader.getAllMovies());
    }

    @GetMapping("/howManyWonAnAward")
    public int howManyWon(){
        return service.howManyWon(fileReader.getAllMovies());
    }

    //TODO:Is it @RequestParam?
    @GetMapping("/filter?char='x'amount='n'")
    public ArrayList<Movie> moviesWithX_NTimes(@RequestParam char x, @RequestParam int n){
        return service.moviesWithXCharNTimes(fileReader.getAllMovies(), x, n);
    }

    //TODO:Gives the wrong answer
    @GetMapping("/longest/g1='x'g2='y'")
    public String genreWithLongestAverage(@RequestParam String x, @RequestParam String y){
        return service.genreWithLongestMovieAverage(fileReader.getAllMovies(), x, y);
    }
}
