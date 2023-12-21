package com.hubberspot.mockito.test_doubles.dummy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DummyBookRepository implements BookRepository {

    // in-memory database,map or list
    Map<String, Book> storeBook = new HashMap<>();

    @Override
    public void saveBook(Book book) {
        storeBook.put(book.getBookId(), book);
    }

    @Override
    public Collection<Book> findAll() {
        return storeBook.values();
    }

    @Override
    public String getBookName(Book book) {
        return storeBook.get(book.getBookId()).getTitle();
    }
}

