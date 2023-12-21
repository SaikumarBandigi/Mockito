package com.hubberspot.mockito.test_doubles.stub;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    void saveBook(Book book);

    Collection<Book> findAll();

    List<Book> findNewBooks(int days);

}