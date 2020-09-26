package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend){
        return friendRepository.save(friend);
    }

    @GetMapping("/friend")
    Iterable<Friend> read(){
        return friendRepository.findAll();
    }

    @PutMapping("/friend")
    Friend update(@RequestBody Friend friend){
        return friendRepository.save(friend);
    }

    @DeleteMapping("/friend/{id}")
    void delete(@PathVariable String id){
        friendRepository.deleteById(id);
    }

    @GetMapping(value = "/friend/{id}")
    Optional<Friend> findById(@PathVariable String id){
        return friendRepository.findById(id);
    }

    @GetMapping(value = "/friend/search")
    Iterable<Friend> findByQuery(@RequestParam(value = "first", required = false) String firstName,
                                 @RequestParam(value = "last", required = false) String lastName){

        if(firstName != null && lastName != null) {
            return friendRepository.findByFirstNameAndLastName(firstName,
                    lastName);
        }else if(firstName != null){
            return friendRepository.findByFirstName(firstName);
        }else if(lastName != null){
            return friendRepository.findByLastName(lastName);
        }else {
            return friendRepository.findAll();
        }

    }


}
