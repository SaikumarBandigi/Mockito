package com.hubberspot.mockito.test_doubles.stub;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {


    @Override
    public void saveBook(Book book) {

    }

    @Override
    public Collection<Book> findAll() {
        return null;
    }

    @Override
    public List<Book> findNewBooks(int days) {
        List<Book> bookList = new LinkedList<>();

        Book book1 = new Book("101", "SONU", 400, LocalDate.now());
        Book book2 = new Book("102", "KOMAL", 500, LocalDate.now());

        bookList.add(book1);
        bookList.add(book2);

        return bookList;
    }
}