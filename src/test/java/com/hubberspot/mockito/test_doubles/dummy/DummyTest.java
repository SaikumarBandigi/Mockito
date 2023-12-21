package com.hubberspot.mockito.test_doubles.dummy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DummyTest {

    static class Sai implements BookRepository {

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

    static class Sonu implements EmailService {
        @Override
        public void sendEmail(String message) {
            throw new AssertionError("Method not Found!!...");
        }
    }


    @Test
    public void testDummy() {

        // test double without mockito
        BookRepository bookRepository = new DummyBookRepository();
        EmailService emailService = new DummyEmailService();

        BookService bookService = new BookService(bookRepository, emailService);

        Book book1 = new Book("1234", "Mockito", 100, LocalDate.now());
        Book book2 = new Book("1235", "Junit", 500, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Assertions.assertEquals(2, bookService.findNumberOfBooks());

    }


    @Test
    public void testDummyWithMockito() {

        // test double with mockito
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);

        BookService bookService = new BookService(bookRepository, emailService);

        Book book1 = new Book("1234", "Mockito", 100, LocalDate.now());
        Book book2 = new Book("1235", "Junit", 500, LocalDate.now());

        Collection<Book> bookCollection = new ArrayList<>();
        bookCollection.add(book1);
        bookCollection.add(book1);

        when(bookRepository.findAll()).thenReturn(bookCollection);
        assertEquals(2, bookService.findNumberOfBooks());

    }

    @Test
    public void testDummyWithMockito2() {

        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);

        BookService bookService = new BookService(bookRepository, emailService);

        Book book1 = new Book("1234", "Mockito", 100, LocalDate.now());
        Book book2 = new Book("1235", "Junit", 500, LocalDate.now());

        // Define behavior for the mock bookRepository
        when(bookRepository.getBookName(book1)).thenReturn(book1.getTitle());

        // Perform some actions using the class under test
        String resultTitle = bookService.getBookName(book1);

        // Assert that the result is as expected
        assertEquals("Mockito", resultTitle);

        // Verify that the getBookName method was called with the expected book
        verify(bookRepository).getBookName(book1);
    }


    @Test
    public void testDummyUsingStaticInnerClass() {

        // Create an instance of the Sai class
        DummyTest.Sai sai = new DummyTest.Sai();

        // Create an instance of the Sonu class (inner class of Sai)
        DummyTest.Sonu sonu = new DummyTest.Sonu();

        // Create an instance of the class under test with the inner class instances
        BookService bookService = new BookService(sai, sonu);

        // Create a sample book
        Book book1 = new Book("1234", "Mockito", 100, LocalDate.now());

        // Perform some actions using the class under test
        bookService.addBook(book1);

        // Assert the result using manual assertions
        assertEquals("Mockito", bookService.getBookName(book1));

    }

}
