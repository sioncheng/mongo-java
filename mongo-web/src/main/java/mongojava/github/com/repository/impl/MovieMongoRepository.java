package mongojava.github.com.repository.impl;

import mongojava.github.com.entity.Movie;
import mongojava.github.com.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class MovieMongoRepository implements MovieRepository {

    private final MongoTemplate mongoTemplate;

    public MovieMongoRepository(@Autowired MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Movie findByTitle(String title) {
        Query query = new Query(Criteria.where("title").is(title));
        return mongoTemplate.findOne(query , Movie.class);
    }
}
