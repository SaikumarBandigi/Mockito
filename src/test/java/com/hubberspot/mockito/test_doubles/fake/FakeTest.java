package com.hubberspot.mockito.test_doubles.fake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class FakeTest {


    @Test
    public void testFakeMethod() {
        // test double without mockito
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito", 100, LocalDate.now());
        Book book2 = new Book("1235", "Junit", 400, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);
        Assertions.assertEquals(2, bookService.findNumberOfBooks());
    }

    @Test
    public void testFakeMethodWithMockito() {
        // test double with mockito
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234", "Mockito", 100, LocalDate.now());
        Book book2 = new Book("1235", "Junit", 400, LocalDate.now());

        Collection<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        when(bookRepository.findAll()).thenReturn(books);
        when(bookRepository.getBookName(book1)).thenReturn(book1.getTitle());

        Assertions.assertEquals(2, bookService.findNumberOfBooks());
        Assertions.assertEquals("Mockito", bookService.getBookName(book1));

    }


}