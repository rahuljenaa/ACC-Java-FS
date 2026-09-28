package com.accenture.ltt.nine;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.stream.Stream;

public class zRefTester1011DatesUntil {

    public static void main(String... args) {
        LocalDate start = LocalDate.of(2017, 12, 1);
        Stream<LocalDate> dates = start.datesUntil(start.plusDays(7));
        dates.forEach(System.out::println);


        
        //Counting number of Leap years from a date till today
        LocalDate birthday = LocalDate.of(1983, 12, 6);

        long leapYears = birthday
                .datesUntil(LocalDate.now(), Period.ofYears(1))
                .map(d -> Year.of(d.getYear()))
                .filter(year->year.isLeap())
                .count();

        System.out.printf("%d leap years since Sander was born on %s", leapYears, birthday);
        
    }
}
