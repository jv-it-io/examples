package be.jnn.training.pluralsight.resttemplate.service.impl;

import be.jnn.training.pluralsight.resttemplate.model.Friend;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    private final MongoTemplate mongoTemplate;

    public FriendServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Friend> findFriendByAgeOrder(int age){
        Query byAge = Query
                .query(Criteria.where("age").gt(age))
                .with(Sort.by(Sort.Direction.DESC, "age"))
                .with(PageRequest.of(0,10));

        List<Friend> friends = mongoTemplate.find(byAge, Friend.class);

        return friends;

    }


}
