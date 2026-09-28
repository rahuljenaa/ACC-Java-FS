package com.accenture.ltt.dummy.red.writ;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class CustomItemReader<T> implements ItemReader<T>{

    List<T> items = new ArrayList<T>();

  /*  public CustomItemReader(List<T> items) {
        this.items = items;
    }
*/
    public T read() throws Exception, UnexpectedInputException, ParseException {
        if (!items.isEmpty()) {
            return items.remove(0);
        }
        return null;
    }
}