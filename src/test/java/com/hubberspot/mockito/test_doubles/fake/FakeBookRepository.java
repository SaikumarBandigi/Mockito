package com.hubberspot.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    // in-memory database,map or list

    Map<String, Book> bookStore = new HashMap<>();

    @Override
    public void saveBook(Book book) {
        bookStore.put(book.getTitle(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }

    @Override
    public String getBookName(Book book) {
        return bookStore.get(book.getBookId()).getTitle();
    }


}

