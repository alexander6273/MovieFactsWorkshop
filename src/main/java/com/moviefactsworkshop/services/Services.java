package com.moviefactsworkshop.services;

import com.moviefactsworkshop.models.Movie;
import org.junit.platform.commons.util.ToStringBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
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
        int randomMovie = ranGen.nextInt(allMovies.size());
        return allMovies.get(randomMovie);
    }

    public ArrayList<Movie> tenSortedMoviesByPop(ArrayList<Movie> allMovies) {
        ArrayList<Movie> tenSortedRandomMovies = new ArrayList<>();
        int run = 0;
        while (run < 10){
            tenSortedRandomMovies.add(getRandomMovie(allMovies));
            run ++;
        }
        Collections.sort(tenSortedRandomMovies);
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

    public ArrayList<Movie> moviesWithXCharNTimes(ArrayList<Movie> allMovies, char x, int n) {
        ArrayList<Movie> moviesThatContainsX_NTimes = new ArrayList<>();
        for (Movie movie : allMovies){
            String X = Character.toString(x);
            if (movie.getTitle().contains(X)){
                //Solution found here: https://www.baeldung.com/java-count-chars
                if (movie.getTitle().chars().filter(ch -> ch == x).count() == n){
                    moviesThatContainsX_NTimes.add(movie);
                }
            }
        }
        return moviesThatContainsX_NTimes;
    }

    //TODO:Gives the wrong answer
    public String genreWithLongestMovieAverage(ArrayList<Movie> allMovies, String x, String y) {
        ArrayList<Integer> skipList = new ArrayList<>();
        int currentCount = 0;
        int finalCount = 0;
        String longestGenre = "";

        for (Movie movies : allMovies){
            if (!skipList.contains(allMovies.indexOf(movies))){
                for (Movie movie : allMovies){
                    if (movie.getSubject().equals(movies.getSubject())){
                        currentCount += movie.getLength();
                        skipList.add(allMovies.indexOf(movie));
                    }
                }
            }
            if (currentCount > finalCount){
                finalCount = currentCount;
                currentCount = 0;
                longestGenre = movies.getSubject();
            }
        }
        return longestGenre;
    }
}
