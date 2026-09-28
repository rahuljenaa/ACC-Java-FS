package com.accenture.ltt.nine;

import java.util.Optional;
import java.util.Set;

import com.accenture.ltt.nine.bean.Book;

public class Tester1006OptionalOr {
    public static void main(String... args) {
        Optional<Book> localFallback = Optional.of(Book.getBook());

        // Before Optional.or
        //we are trying to get books with offer
        // if not found then get from external
        // if not found from the external then get from the local
        // using get is bad as even local fallback could return null
        Book bestBookBefore = getBestOffer()
                .orElse(getExternalOffer().orElse(localFallback.get()));  // .get() is BAD!

        
        Optional<Book> bestBook =
                getBestOffer()
                .or(() -> getExternalOffer())
                .or(() -> localFallback);
        
        System.out.println(bestBook);
    }

    static Optional<Book> getBestOffer() {
        return Optional.empty();
    }

    static Optional<Book> getExternalOffer() {
        return Optional.of(new Book("External Book", Set.of(), 11.99));
    }
}



/**new methods of Optional 
 * 
 *	void ifPresentOrElse(Consumer<T> action,Runnable emptyAction)
 *	Optional<T> or(Supplier<Optional<T>> supplier)
 *	Stream<T> stream()  
 * */
 