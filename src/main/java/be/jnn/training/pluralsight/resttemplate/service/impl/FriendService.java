package be.jnn.training.pluralsight.resttemplate.service.impl;

import be.jnn.training.pluralsight.resttemplate.model.Friend;

import java.util.List;

public interface FriendService {

    public List<Friend> findFriendByAgeOrder(int age);
}
