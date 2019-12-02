package com.gulyasadam.Entity;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.text.SimpleDateFormat;
import java.util.Date;

@Document(collection = "movies")
public class Movie {
   @Id
    private Integer id;
    private String name;
    private String creation_date;
    private double imdb_points;
    private Integer length_in_minutes;
    private String director;
    private String writer;
    private String stars;

    public Movie(Integer id, String name, String creation_date, double imdb_points, Integer length_in_minutes, String director, String writer, String stars) throws Exception {
        this.id = this.setId(id);
        this.name = this.setName(name);
        this.creation_date = this.setCreation_date(creation_date);
        this.imdb_points = this.setImdb_points(imdb_points);
        this.length_in_minutes = this.setLength_in_minutes(length_in_minutes);
        this.director = this.setDirector(director);
        this.writer = this.setWriter(writer);
        this.stars = this.setStars(stars);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", creation_date='" + getCreation_date() + '\'' +
                ", imdb_points=" + getImdb_points() +
                ", length_in_minutes=" + getLength_in_minutes() +
                ", director='" + getDirector() + '\'' +
                ", writer='" + getWriter() + '\'' +
                ", stars='" + getStars() + '\'' +
                '}';
    }

    public Movie()
    {

    }
    public Movie(Movie movie) throws Exception {
        this.id = this.setId(movie.id);
        this.name = this.setName(movie.name);
        this.creation_date = this.setCreation_date(movie.creation_date);
        this.imdb_points = this.setImdb_points(movie.imdb_points);
        this.length_in_minutes = this.setLength_in_minutes(movie.length_in_minutes);
        this.director = this.setDirector(movie.director);
        this.writer = this.setWriter(movie.writer);
        this.stars = this.setStars(movie.stars);
    }

    public Integer getId() {
        return id;
    }

    public Integer setId(Integer id) {
        return this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {

        if(name.length() < 1)
        {
            return "A film címe üres!";
        }
        else
        {
            return this.name = name;
        }
    }

    public String getCreation_date() {
        return creation_date;
    }

    public String setCreation_date(String creation_date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
        Date date1 = sdf.parse("1899-12-31");
        Date date2 = sdf.parse(creation_date);

        if(date1.compareTo(date2) < 0)
        {
            return this.creation_date = creation_date;
        }
        else
        {
            return "Csak 1899-12-31 utáni filmeket lehet felvinni!";
        }

    }

    public double getImdb_points() {
        return imdb_points;
    }

    public double setImdb_points(double imdb_points) throws Exception {

        if(imdb_points > 0.0 && imdb_points < 10.0)
        {

            return this.imdb_points = imdb_points;
        }
        else
            throw new Exception("IMDb csak 0.0 és 10.0 közötti lehet!");
    }

    public Integer getLength_in_minutes() {
        return length_in_minutes;
    }

    public Integer setLength_in_minutes(Integer length_in_minutes) throws Exception {

        if(length_in_minutes > 0 && length_in_minutes < 51420)
            return this.length_in_minutes = length_in_minutes;
        else
            throw new Exception("A film hossza 1 perc és 51420 közötti lehet!");
        //https://en.wikipedia.org/wiki/List_of_longest_films
    }

    public String getDirector() {
        return director;
    }

    public String setDirector(String director)  {
        if(director.length() < 1)
        {
            return "Nincs megadva a film rendezője(i)!";
        }
        else
        {
            return this.director = director;
        }
    }

    public String getWriter() {
        return writer;
    }

    public String setWriter(String writer)  {
        if(writer.length() < 1)
        {
            return "Nincs megadva a film írója(i)!";
        }
        else
        {
            return this.writer = writer;
        }
    }

    public String getStars() {
        return stars;
    }

    public String setStars(String stars)  {
        if(stars.length() < 1)
        {
            return "Nincs megadva a film szereplője(i)!";
        }
        else
        {
            return this.stars = stars;
        }
    }
}
