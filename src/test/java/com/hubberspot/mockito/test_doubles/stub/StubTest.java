package com.hubberspot.mockito.test_doubles.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StubTest {

    @Test
    public void testSUBTEST() {
        // test double without mockito
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);

        List<Book> bookList = bookService.getNewBooks(2, 6);

        Assertions.assertEquals(2, bookList.size());
        Assertions.assertEquals(392,bookList.get(0).getPrice());
        Assertions.assertEquals(490,bookList.get(1).getPrice());
    }
}
