package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.Race;
import be.jnn.training.pluralsight.resttemplate.model.student.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/races")
public class RaceController {


    private static final List<Race> RACES = Arrays.asList(
            new Race("1", "Bruxelles"),
            new Race("2", "Barcelone"),
            new Race("3", "New York")
    );

    @GetMapping()
    public List<Race> getStudent(){
        return RACES.stream()
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{raceId}")
    public Race getStudent(@PathVariable("raceId") String id){
        return RACES.stream()
                .filter(student -> id.equals(student.getRaceId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + id + " doesn't exist"));
    }
}
