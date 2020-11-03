package be.jnn.training.pluralsight.resttemplate;

import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class ServicesTest {

    @Autowired
    FriendRepository friendRepository;

    @Before
    public void cleanUp(){
        friendRepository.deleteAll();
    }

    @Test
    public void testCreateAndDelete(){
        Assertions.assertThat(friendRepository.findAll()).isEmpty();

        Friend friend = new Friend("Gordon", "Moore");

        Friend friendResultCreate = friendRepository.save(friend);

        List<Friend> friends = friendRepository.findAll();
        Assertions.assertThat(friends).extracting(Friend::getFirstName).containsOnly("Gordon");

        friendRepository.delete(friendResultCreate);

        Assertions.assertThat(friendRepository.findAll()).isEmpty();
    }

}
