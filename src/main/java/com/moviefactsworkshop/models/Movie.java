package com.moviefactsworkshop.models;

public class Movie
{
    private int year;
    private int length;
    private String title;
    private int popularity;
    private boolean awards;

    public Movie(int year, int length, String title, int popularity, boolean awards)
    {
        this.year = year;
        this.length = length;
        this.title = title;
        this.popularity = popularity;
        this.awards = awards;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public int getPopularity()
    {
        return popularity;
    }

    public void setPopularity(int popularity)
    {
        this.popularity = popularity;
    }

    public boolean isAwards()
    {
        return awards;
    }

    public void setAwards(boolean awards)
    {
        this.awards = awards;
    }

    @Override
    public String toString()
    {
        return "Title: " + title +
                ", year: " + year +
                ", length: " + length + " minuts" +
                ", popularity: " + popularity + "%" +
                ", awards: " + awards +
                '}';
    }
}