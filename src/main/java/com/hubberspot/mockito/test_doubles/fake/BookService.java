package com.hubberspot.mockito.test_doubles.fake;


public class BookService {

    public BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

    public int findNumberOfBooks() {
        return bookRepository.findAll().size();
    }

    public String getBookName(Book book) {
        return book.getTitle();
    }


}
