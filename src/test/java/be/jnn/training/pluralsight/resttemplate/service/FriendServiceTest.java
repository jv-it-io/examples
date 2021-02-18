package be.jnn.training.pluralsight.resttemplate.service;


import be.jnn.training.pluralsight.resttemplate.model.Address;
import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.AddressRepository;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import be.jnn.training.pluralsight.resttemplate.service.impl.FriendServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class FriendServiceTest {

    @Autowired
    MongoTemplate mongoTemplate;


    @Autowired
    FriendServiceImpl friendServiceImpl;

    @Autowired
    FriendRepository friendRepository;

    @Autowired
    AddressRepository addressRepository;


    @TestConfiguration
    static class FriendServiceImplTestContextConfiguration {
        @Bean
        public FriendServiceImpl friendService(MongoTemplate mongoTemplate) {
            return new FriendServiceImpl(mongoTemplate);
        }
    }


    @Before
    public void setUp() {
        Address addressOne = new Address();
        addressOne.setCity("New York");
        addressOne.setStreet("5th Av.");

        addressRepository.insert(addressOne);

        Friend friendOne = new Friend("John", "Doe");
        friendOne.setAge(25);



        Friend friendTwo = new Friend("John", "Matrix");
        friendTwo.setAge(46);

        Friend friendThree = new Friend("John", "McClane");
        friendThree.setAge(38);
        friendThree.setAddresses(Arrays.asList(addressOne));

        Friend friendFour = new Friend("John", "Conor");
        friendFour.setAge(15);

        Friend friendFive = new Friend("John", "Wick");
        friendFive.setAge(40);

        Friend friendSix = new Friend("John", "Rambo");
        friendSix.setAge(32);

        Friend friendSeven = new Friend("John", "Spartan");
        friendSeven.setAge(99);


        List<Friend> friends = Arrays.asList(friendOne, friendTwo, friendThree, friendFour, friendFive, friendSix, friendSeven);

        this.friendRepository.saveAll(friends);

    }

    @Test
    public void findByAgeGT() {
        List<Friend> friendByAgeOrder = friendServiceImpl.findFriendByAgeOrder(35);

        assertNotNull(friendByAgeOrder);
        assertFalse(friendByAgeOrder.isEmpty());
        assertEquals(4, friendByAgeOrder.size());
    }

    @Test
    public void getAddressTest(){
        List<Friend> mcClane = friendRepository.findByLastName("McClane");

        assertNotNull(mcClane);
        assertFalse(mcClane.isEmpty());

        Friend friend = mcClane.get(0);

        assertNotNull(friend.getAddresses());
        assertFalse(friend.getAddresses().isEmpty());
        Address address = friend.getAddresses().get(0);
        assertEquals("New York", address.getCity());
        assertEquals("5th Av.", address.getStreet());
    }

    @AfterEach
    public void teardown() {
        this.mongoTemplate.dropCollection(Friend.class);
    }
}
