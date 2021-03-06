package com.moviefactsworkshop.models;

public class Movie implements Comparable
{
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie(int year, int length, String title, String subject, int popularity, boolean awards)
    {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getPopularity()
    {
        return popularity;
    }

    public void setPopularity(int popularity)
    {
        this.popularity = popularity;
    }

    public boolean isAwards() {
        return awards;
    }

    public void setAwards(boolean awards)
    {
        this.awards = awards;
    }

    @Override
    public int compareTo(Object other){
        Movie otherMovie = (Movie) other;
        if (this.popularity < otherMovie.popularity){
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString()
    {
        return "Title: " + title +
                ", year: " + year +
                ", length: " + length + " minuts" +
                ", subject: " + subject +
                ", popularity: " + popularity + "%" +
                ", awards: " + awards +
                "\n";
    }
}
