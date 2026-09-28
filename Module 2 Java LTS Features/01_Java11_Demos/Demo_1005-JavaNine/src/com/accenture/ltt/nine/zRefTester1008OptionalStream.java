package com.accenture.ltt.nine;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class zRefTester1008OptionalStream {

    public static void main(String[] args) {

    	
    	 // given
        Optional<String> value = Optional.of("a");
     
        // when
        List<String> collect = value.stream().map(String::toUpperCase).collect(Collectors.toList());
     
    	System.out.println(collect);
    	
    	
    	//Demo 2 
        Stream<Optional<Integer>> optionals =
                Stream.of(Optional.of(1), Optional.empty(), Optional.of(2));

        Stream<Integer> ints = optionals.flatMap(x->x.stream());

        System.out.println(ints);


    }
}
//. The Java 9 introduces the stream() method on the Optional class that allows us to treat the Optional instance as a Stream.
// Stream will operate on the underlying value/Datatype of Optional


//https://www.baeldung.com/java-9-optional