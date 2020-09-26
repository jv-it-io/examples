package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.Message;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    //Respond body to tell to speing that method return object so it
    //converts it in json message
    @ResponseBody
    @GetMapping("/message")
    Message send(){
            return new Message("My first message");
    }

    @PostMapping("/message")
    Message echo(@RequestBody Message message){
        return message;
    }

}
