package com.hubberspot.mockito.test_doubles.mock;

import com.hubberspot.mockito.test_doubles.spy.Book;
import com.hubberspot.mockito.test_doubles.spy.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class MockTest {

    @Test
    public void demoMOCK() {
        // test double without mockito
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("101", "SONU", 500, LocalDate.now());
        Book book2 = new Book("102", "KOMAL", 400, LocalDate.now());

        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called

        bookRepositoryMock.verify(book2, 1);

    }

}
