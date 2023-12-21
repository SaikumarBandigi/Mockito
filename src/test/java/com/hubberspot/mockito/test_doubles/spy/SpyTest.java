package com.hubberspot.mockito.test_doubles.spy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SpyTest {

    @Test
    public void demoSPY() {
        // test double without mockito
        BookRepositorySpy bookRepositoryspy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositoryspy);

        Book book1 = new Book("101", "SONU", 500, LocalDate.now());
        Book book2 = new Book("102", "KOMAL", 400, LocalDate.now());

        bookService.addBook(book1);
        Assertions.assertEquals(0,bookRepositoryspy.timesCalled());

       // Assertions.assertTrue(bookRepositoryspy.calledWith(book2));

        bookService.addBook(book2);
        Assertions.assertEquals(1,bookRepositoryspy.timesCalled());
    }

}
