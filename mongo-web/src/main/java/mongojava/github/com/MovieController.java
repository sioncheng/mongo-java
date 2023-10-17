package mongojava.github.com;

import mongojava.github.com.entity.Movie;
import mongojava.github.com.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(@Autowired MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostMapping("/findByTitle")
    @ResponseBody
    public ResponseEntity<Movie> findByTitle(@RequestBody Movie movie) {
        if (movie == null || movie.getTitle() == null || movie.getTitle().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Movie movie1 = movieRepository.findByTitle(movie.getTitle());
        return ResponseEntity.ok(movie1);
    }
}
