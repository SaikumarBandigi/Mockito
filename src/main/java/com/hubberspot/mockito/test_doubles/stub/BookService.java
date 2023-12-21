package com.hubberspot.mockito.test_doubles.stub;


import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBooks(int discount, int days) {
        List<Book> books = bookRepository.findNewBooks(days);

        for (Book newBooks : books) {
            int price = newBooks.getPrice();
            int newPrice = price - (discount * price) / 100;
            newBooks.setPrice(newPrice);
        }
        return books;
    }


}
