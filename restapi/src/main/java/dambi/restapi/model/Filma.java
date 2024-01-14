package dambi.restapi.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Filma {
    private String title;
    private int year;
    private String kind;
    private String genre;
    private double rating;
    private int vote;
    private String country;
    private String language;
    private List<Cast> cast;
    private String writer;

    public Filma() {
    }

    public Filma(String title, int year, String kind, String genre, double rating, int vote, String country,
            String language, List<Cast> cast, String writer) {
        this.title = title;
        this.year = year;
        this.kind = kind;
        this.genre = genre;
        this.rating = rating;
        this.vote = vote;
        this.country = country;
        this.language = language;
        this.cast = cast;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}