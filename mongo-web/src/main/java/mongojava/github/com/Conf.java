package mongojava.github.com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

@Configuration
public class Conf {

    @Bean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory factory){
        return new MongoTransactionManager(factory);
    }
}
