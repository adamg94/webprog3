package com.gulyasadam.Service;

import com.gulyasadam.Dao.MovieRepository;
import com.gulyasadam.Entity.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MovieRepository.class)
@Configuration
public class MongoConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                movieRepository.save(new Movie(
                        1,
                        "Film1",
                        "2010-10-10",
                        4.5,
                        120,
                        "Andy Vajna",
                        "Arnold D",
                        "Stzárok,Sztárok"
                ));
                movieRepository.save(new Movie(
                        2,
                        "Film2",
                        "2010-10-10",
                        4.5,
                        120,
                        "Andy Vajna",
                        "Arnold D",
                        "Stzárok,Sztárok"
                ));
            }
        };
    }
}
