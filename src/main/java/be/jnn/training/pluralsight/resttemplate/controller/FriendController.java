package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.FieldErrorMessage;
import be.jnn.training.pluralsight.resttemplate.model.Friend;
import be.jnn.training.pluralsight.resttemplate.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;


@RestController
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @PostMapping("/friend")
    public Friend create(@RequestBody @Valid Friend friend)  {

            return friendRepository.save(friend);

    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exception(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream().map(error -> new FieldErrorMessage(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());

        return fieldErrorMessages;
    }


    @GetMapping("/friend")
    public Iterable<Friend> read(){
        return friendRepository.findAll();
    }

    @PutMapping("/friend")
    public ResponseEntity<Friend> update(@RequestBody Friend friend)
    {
        if(friendRepository.findById(friend.getId()).isPresent())
            return new ResponseEntity(friendRepository.save(friend), HttpStatus.OK);
        else
            return new ResponseEntity(friend, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/friend/{id}")
    public void delete(@PathVariable String id){
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
