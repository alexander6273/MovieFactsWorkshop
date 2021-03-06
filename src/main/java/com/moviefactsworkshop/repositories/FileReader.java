package com.moviefactsworkshop.repositories;

import com.moviefactsworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader
{
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Movie> allMovies = new ArrayList<>();

    public ArrayList<Movie> getAllMovies() {
        loadMovies();
        return allMovies;
    }

    public void setAllMovies(ArrayList<Movie> allMovies) {
        this.allMovies = allMovies;
    }

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

        //Skips the first line
        sc.nextLine();

        while(sc.hasNextLine()){

            //reading the movie file
            String line = sc.nextLine();
            String[] stringAsArray = line.split(";");

            //instantiating the movie attributes
            int year = Integer.parseInt(stringAsArray[0]);
            int length = Integer.parseInt(stringAsArray[1]);
            String title = stringAsArray[2];
            String subject = stringAsArray[3];
            int popularity = Integer.parseInt(stringAsArray[4]);

            boolean awards = false;
            if (stringAsArray[5].equals("Yes") ) {
                awards = true;
            }

            Movie currentMovie = new Movie(year, length, title, subject, popularity, awards);
            allMovies.add(currentMovie);
        }
    }
}
