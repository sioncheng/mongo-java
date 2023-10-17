package mongojava.github.com.repository;

import mongojava.github.com.entity.Movie;

public interface MovieRepository {

    public Movie findByTitle(String title);
}
