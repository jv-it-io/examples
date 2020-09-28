package be.jnn.training.pluralsight.resttemplate.controller;

import be.jnn.training.pluralsight.resttemplate.model.ErrorMessage;
import be.jnn.training.pluralsight.resttemplate.model.FieldErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

//@ControllerAdvice
public class ControllerException {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException e){
        return new ErrorMessage("400", e.getMessage());
    }


}
