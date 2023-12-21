package com.hubberspot.mockito.test_doubles.fake;

import java.util.Collection;

public interface BookRepository {

    void saveBook(Book book);

    Collection<Book> findAll();

    String getBookName(Book book);


}