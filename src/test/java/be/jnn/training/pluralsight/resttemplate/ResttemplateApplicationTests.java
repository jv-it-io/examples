package be.jnn.training.pluralsight.resttemplate;

import be.jnn.training.pluralsight.resttemplate.controller.FriendController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ResttemplateApplicationTests {

    @Autowired
    FriendController friendController;

    @Test
    void contextLoads() {
        Assert.assertNotNull(friendController);
    }

}
