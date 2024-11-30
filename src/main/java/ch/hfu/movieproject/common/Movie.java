package ch.hfu.movieproject.common;


public class Movie {
    private int id = -1;
    private String title;
    private int year;

    public Movie() {
    }

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
