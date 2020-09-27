package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.ErrorMessage;
import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @PostMapping("/friend")
    Friend create(@RequestBody Friend friend) throws ValidationException {
        if(friend.getId() != null &&
        friend.getLastName() != null &&
        friend.getFirstName() != null) {
            return friendRepository.save(friend);
        }
        else{
           throw new ValidationException("Friend cannot be created");
        }
    }



    @GetMapping("/friend")
    Iterable<Friend> read(){
        return friendRepository.findAll();
    }

    @PutMapping("/friend")
    ResponseEntity<Friend> update(@RequestBody Friend friend)
    {
        if(friendRepository.findById(friend.getId()).isPresent())
            return new ResponseEntity(friendRepository.save(friend), HttpStatus.OK);
        else
            return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);

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
