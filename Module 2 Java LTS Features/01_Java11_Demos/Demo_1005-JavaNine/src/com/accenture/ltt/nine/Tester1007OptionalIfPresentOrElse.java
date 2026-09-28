package com.accenture.ltt.nine;

import java.util.Optional;

import com.accenture.ltt.nine.bean.Book;

public class Tester1007OptionalIfPresentOrElse {

    public static void main(String... args) {
        Optional<Book> full = Optional.of(Book.getBook());

        
        // Before ifPresentOrElse
        full.ifPresent(x->System.out.println("1-->"+x));

        if (full.isPresent()) {
            System.out.println("2-->"+full.get());
        } else {
            System.out.println("Nothing here");
        }

        
        
        //Now
        full.ifPresentOrElse(x->System.out.println("3-->"+x),
                () -> System.out.println("Nothing here!"));
        
        
        
        Optional.empty().ifPresentOrElse(x->System.out.println("4-->"+x),
                () -> System.out.println("Nothing here!"));

    }

}
