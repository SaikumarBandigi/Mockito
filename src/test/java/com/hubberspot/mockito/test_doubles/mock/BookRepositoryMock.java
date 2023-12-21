package com.hubberspot.mockito.test_doubles.mock;

import com.hubberspot.mockito.test_doubles.spy.Book;
import com.hubberspot.mockito.test_doubles.spy.BookRepository;
import org.junit.jupiter.api.Assertions;

public class BookRepositoryMock implements BookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void saveBook(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }

    public void verify(Book book, int times) {
        Assertions.assertEquals(times, saveCalled);
        Assertions.assertEquals(book, lastAddedBook);
    }

}
