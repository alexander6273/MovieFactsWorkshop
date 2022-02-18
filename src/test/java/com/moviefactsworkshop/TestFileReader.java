package com.moviefactsworkshop;

import com.moviefactsworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestFileReader {

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
        TestFileReader testFileReader = new TestFileReader();
        testFileReader.loadMovies();
        Random ran = new Random();
        System.out.println(testFileReader.allMovies.size());
        int run = 0;
        while (run < 10){
            int random = ran.nextInt(testFileReader.allMovies.size());
            System.out.println(testFileReader.allMovies.get(random).getTitle());
            run ++;
        }

    }
}
