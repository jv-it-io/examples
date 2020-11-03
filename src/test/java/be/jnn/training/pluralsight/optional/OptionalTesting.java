package be.jnn.training.pluralsight.optional;

import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;


public class OptionalTesting {

     final String MESSAGE = "Hello World!";
     final String MESSAGE_UPDATE = "Hello World! version 2";

    @Test
    public void createEmptyObjectOptional(){
        Optional<String> optional = Optional.empty();
        assertThat(optional).isEmpty();
    }
    @Test
    public void createObjectOptional(){
        Optional<String> optional = Optional.of("Hello world!");
        assertThat(optional.get()).isEqualTo("Hello world!");
    }
    @Test(expected = NullPointerException.class)
    public void createObjectOptionalThrowNullPointer(){
        Optional<String> optional = Optional.of(null);
        optional.get();
        //use .ofNullable to avoid NullPointerEception
    }

    @Test
    public void createObjectOptionalCheckValue(){
        Optional<String> optional = Optional.ofNullable(null);
        assertThat(optional.isPresent()).isFalse();

        optional = Optional.ofNullable("Hello world!");
        assertThat(optional.isPresent()).isTrue();

        //JAVA 11 method isEmpty can be used to check value

    }

    @Test
    public void createObjectOptionalConditionalAction(){
        Optional<String> optional = Optional.ofNullable("Hello world!");
        AtomicInteger emptyValue = new AtomicInteger();
        optional.ifPresent(value -> emptyValue.set(value.length()));
        assertThat(emptyValue.get()).isGreaterThan(0);
        //JAVA 9 or more,  can use the the method  ifPresentOrElse
    }

    @Test
    public void createObjectOptionalDefaultValuen(){
        Optional<String> optional = Optional.ofNullable(null);
        assertThat(optional.orElse(MESSAGE)).isEqualTo(MESSAGE);

        optional = Optional.ofNullable(MESSAGE_UPDATE);
        assertThat(optional.orElse(MESSAGE)).isEqualTo(MESSAGE_UPDATE);

    }

    @Test
    public void createObjectOptionalOrElseGet(){
        Optional<String> optional = Optional.ofNullable("Hello world!");
        int emptyValue = MESSAGE.length();
        optional.orElseGet(() -> String.valueOf("".length()));
        assertThat(emptyValue).isGreaterThan(0);

        optional = Optional.ofNullable(null);
        emptyValue = 0;
        optional.orElseGet(() -> String.valueOf("".length()));
        assertThat(emptyValue).isEqualTo(0);

        //JAVA 9 or more, or() can be used to perform an optional value
//        optional = Optional.ofNullable(null);
//        Optional<String> optional2 = Optional.ofNullable("Default!");
//        optional.or() -> optional2;

    }




}
