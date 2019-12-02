package com.gulyasadam.Dao;
import com.gulyasadam.Entity.Movie;
import java.util.Collection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, Integer>{

}
