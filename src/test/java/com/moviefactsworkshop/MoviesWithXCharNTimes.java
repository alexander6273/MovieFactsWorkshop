package com.moviefactsworkshop;

import com.moviefactsworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MoviesWithXCharNTimes {
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
        MoviesWithXCharNTimes test = new MoviesWithXCharNTimes();
        test.loadMovies();
        ArrayList<Movie> moviesThatContainsX = new ArrayList<>();
        char x = 'e';
        int n = 1;
        for (Movie movie : test.allMovies){
            String X = Character.toString(x);
            if (movie.getTitle().contains(X)){
                if (movie.getTitle().chars().filter(ch -> ch == x).count() == n)
                moviesThatContainsX.add(movie);
            }
        }
        System.out.println(moviesThatContainsX);
        System.out.println(moviesThatContainsX.size());
    }
}
