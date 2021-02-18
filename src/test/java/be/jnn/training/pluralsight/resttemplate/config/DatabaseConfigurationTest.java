package be.jnn.training.pluralsight.resttemplate.config;

import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@TestConfiguration
@DisplayName("Configuration For standalone mongodb")
public class DatabaseConfigurationTest {

    //To use stand alone mongo instead embeded
    // 1. remove embeded dependency in pom
    // 2. set url to your local db in SimpleMongoClientDatabaseFactory (URI)
    // 3. decomment bean and import config in test

//    @Bean
//    public SimpleMongoClientDatabaseFactory mongoDatabaseFactory(){
//        return new SimpleMongoClientDatabaseFactory("...");
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory){
//        return new MongoTemplate(mongoDatabaseFactory);
//    }
}
