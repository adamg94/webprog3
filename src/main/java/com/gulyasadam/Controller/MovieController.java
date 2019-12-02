package com.gulyasadam.Controller;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.gulyasadam.Dao.MovieRepository;
import com.gulyasadam.Entity.Movie;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.script.ScriptContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    public Integer ID = 5;

    private MovieRepository movieRepository;
    public MovieController(MovieRepository movieRepository)
    {
       this.movieRepository = movieRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<Movie> getAll() {
        return this.movieRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Movie> getMovieById(@PathVariable("id") Integer id){
            return this.movieRepository.findById(id);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> updateMovie(@RequestBody Map<String, String> movie){


        try{

            Movie m  = new Movie(
                    Integer.parseInt(movie.get("id")),
                    movie.get("name"),
                    movie.get("creation_date"),
                    Double.parseDouble(movie.get("imdb_points")),
                    Integer.parseInt(movie.get("length_in_minutes")),
                    movie.get("director"),
                    movie.get("writer"),
                    movie.get("stars"));
            this.movieRepository.save(m);
            HashMap<String, String> map = new HashMap<>();
            map.put("success", "true");
            map.put("message", "Sikeres módosítás!");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            HashMap<String, String> map = new HashMap<>();
            map.put("success", "false");
            map.put("message", "Módosítás sikertelen! : " + e);
            return map;

        }
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> insertMovie(@RequestBody Map<String, String> movie){


        try{

            Movie m  = new Movie(
                    ++ID,
                    movie.get("name"),
                    movie.get("creation_date"),
                    Double.parseDouble(movie.get("imdb_points")),
                    Integer.parseInt(movie.get("length_in_minutes")),
                    movie.get("director"),
                    movie.get("writer"),
                    movie.get("stars"));
            this.movieRepository.insert(m);
            HashMap<String, String> map = new HashMap<>();
            map.put("success", "true");
            map.put("message", "Sikeres felvitel!");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            HashMap<String, String> map = new HashMap<>();
            map.put("success", "false");
            map.put("message", "Felvitel sikertelen! : " + e);
            return map;

        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public Map<String, String> deleteMovie(@PathVariable("id") Integer id){
        this.movieRepository.deleteById(id);
        try{
            this.movieRepository.deleteById(id);
            HashMap<String, String> map = new HashMap<>();
            map.put("success", "true");
            map.put("message", "Sikeres törlés!");
            return map;
        }
        catch (Exception e) {
            e.printStackTrace();
            HashMap<String, String> map = new HashMap<>();
            map.put("success", "false");
            map.put("message", "Törlési Hiba! : " + e);
            return map;

        }
    }

}
