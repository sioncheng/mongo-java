package mongojava.github.com.repository.impl;

import com.mongodb.client.result.UpdateResult;
import mongojava.github.com.entity.Points;
import mongojava.github.com.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PointsRepositoryImpl implements PointsRepository {

    private final MongoTemplate mongoTemplate;

    public PointsRepositoryImpl(@Autowired MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Points findByAccount(String account) {
        Query query = new Query(Criteria.where("account").is(account));
        return mongoTemplate.findOne(query, Points.class);
    }

    @Override
    @Transactional(value = "transactionManager")
    @Retryable(value = UncategorizedMongoDbException.class, exceptionExpression = "#{message.contains('WriteConflict error')}", maxAttempts = 20, backoff = @Backoff(delay = 500))
    public boolean incAmount(String account, Integer inc) {
        Query query = new Query(Criteria.where("account").is(account));
        Update update = new Update().inc("amount", inc);
        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Points.class);
        return updateResult.getMatchedCount() == 1;
    }
}
