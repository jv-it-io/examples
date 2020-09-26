package be.jnn.training.pluralsight.resttemplate.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories("be.jnn.training.pluralsight.resttemplate.repository")
@Import(value = MongoAutoConfiguration.class)
public class MongoConfig {


}
