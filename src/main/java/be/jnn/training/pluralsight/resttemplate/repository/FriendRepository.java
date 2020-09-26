package be.jnn.training.pluralsight.resttemplate.repository;

import be.jnn.training.pluralsight.resttemplate.model.Friend;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends MongoRepository<Friend, String> {
    Iterable<Friend> findByFirstNameAndLastName(String firstName,
                                                String lastName);

    Iterable<Friend> findByFirstName(String first);

    Iterable<Friend> findByLastName(String last);
}
