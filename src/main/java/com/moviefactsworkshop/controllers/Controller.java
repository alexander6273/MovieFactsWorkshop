package com.moviefactsworkshop.controllers;

import com.moviefactsworkshop.models.Movie;
import com.moviefactsworkshop.repositories.FileReader;
import com.moviefactsworkshop.services.Services;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //TODO: implement sort
    @GetMapping("/getTenSortByPopularity")
    public ArrayList<Movie> sortTenRandomMoviesByPop(){
        return service.tenSortedMoviesByPop(fileReader.getAllMovies());
    }

    @GetMapping("/howManyWonAnAward")
    public int howManyWon(){
        return service.howManyWon(fileReader.getAllMovies());
    }

    //TODO:
    @GetMapping("/filter?char='x'amount='n'")
    public ArrayList<Movie> moviesWithX_NTimes(){
        return service.tenSortedMoviesByPop(fileReader.getAllMovies());
    }

    //TODO:
    @GetMapping("/longest/g1='x'g2='y'")
    public ArrayList<Movie> genreWithLongestAverage(){
        return service.tenSortedMoviesByPop(fileReader.getAllMovies());
    }
}
