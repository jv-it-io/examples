package be.jnn.training.pluralsight.resttemplate;

import be.jnn.training.pluralsight.resttemplate.controller.FriendController;
import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    FriendController friendController;

    @Autowired
    FriendRepository friendRepository;

    //Run before to clean data because it uses the real DB
    @Before
    public void cleanData(){
        friendRepository.deleteAll();
    }

    @DisplayName("given object to save"
            + " when save object using MongoDB template"
            + " then object is saved")
    @Test
    public void testCreateReadDelete() {

        Friend friend = new Friend("John", "Doe");

        Friend friendResultCreate = friendController.create(friend);

        Iterable<Friend> friends = friendController.read();

        Assertions.assertThat(friends).first().hasFieldOrPropertyWithValue("firstName", "John");

        friendController.delete(friendResultCreate.getId());

        Assertions.assertThat(friendController.read()).isEmpty();


    }
}
