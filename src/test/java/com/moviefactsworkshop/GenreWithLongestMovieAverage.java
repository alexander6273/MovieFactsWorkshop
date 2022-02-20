package com.moviefactsworkshop;

import com.moviefactsworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GenreWithLongestMovieAverage {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Movie> allMovies = new ArrayList<>();

    public Scanner reader(String fileName){
        File file = new File(fileName);
        try{
            return new Scanner(file);
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find the file");
            e.printStackTrace();
        }
        return sc;
    }

    public void loadMovies(){
        sc = reader("src/main/resources/static/imdb-data.csv");
        sc.nextLine();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] stringAsArray = line.split(";");
            int year = Integer.parseInt(stringAsArray[0]);
            int length = Integer.parseInt(stringAsArray[1]);
            String title = stringAsArray[2];
            String subject = stringAsArray[3];
            int popularity = Integer.parseInt(stringAsArray[4]);
            boolean awards = Boolean.parseBoolean(stringAsArray[5]);
            Movie currentMovie = new Movie(year, length, title, subject, popularity, awards);
            allMovies.add(currentMovie);
        }

    }

    public static void main(String[] args) {
        GenreWithLongestMovieAverage test = new GenreWithLongestMovieAverage();
        test.loadMovies();
        ArrayList<Integer> skip = new ArrayList<>();
        int currentCount = 0;
        int finalCount = 0;
        String longestGenre = "";
        String title = "";

        for (Movie movies : test.allMovies){
            if (!skip.contains(test.allMovies.indexOf(movies)) ){
                for (Movie movie : test.allMovies){
                    if (movie.getSubject().equals(movies.getSubject())){
                        currentCount += movie.getLength();
                        skip.add(test.allMovies.indexOf(movie));
                        if (currentCount > finalCount)
                        longestGenre = movie.getSubject();
                    }
                }
            }
            if (currentCount > finalCount){
                finalCount = currentCount;
                currentCount = 0;
                title = movies.getTitle();
                //longestGenre = movie.getSubject();

            }
        }
        System.out.println(finalCount);
        System.out.println(title);
        System.out.println(longestGenre);

        //taget is: length 66318, subject drama
    }
}
