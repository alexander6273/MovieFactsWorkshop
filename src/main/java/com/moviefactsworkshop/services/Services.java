package com.moviefactsworkshop.services;

import com.moviefactsworkshop.models.Movie;

import java.util.ArrayList;
import java.util.Random;

public class Services
{
    private Random ranGen = new Random();

    public String getFirstMovieTitle(ArrayList<Movie> allMovies){
        return allMovies.get(1).getTitle();
    }

    public String getRandomTitle(ArrayList<Movie> allMovies) {
        int randomMovieTitle = ranGen.nextInt(allMovies.size());
        return allMovies.get(randomMovieTitle).getTitle();
    }

    public Movie getRandomMovie(ArrayList<Movie> allMovies){
        int randomMovieTitle = ranGen.nextInt(allMovies.size());
        return allMovies.get(randomMovieTitle);
    }

    //TODO: implement sort
    public ArrayList<Movie> tenSortedMoviesByPop(ArrayList<Movie> allMovies) {
        ArrayList<Movie> tenSortedRandomMovies = new ArrayList<>();
        int run = 0;
        while (run < 10){
            tenSortedRandomMovies.add(getRandomMovie(allMovies));
            run ++;
        }
        return tenSortedRandomMovies;
    }

    public int howManyWon(ArrayList<Movie> allMovies) {
        ArrayList<Movie> moviesThatWon = new ArrayList<>();
        int count = 0;

        for (Movie a : allMovies) {
            if (a.isAwards()) {
                count += 1;
            }
        }
        return count;
    }
}
