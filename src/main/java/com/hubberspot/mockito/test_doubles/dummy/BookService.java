package com.hubberspot.mockito.test_doubles.dummy;


public class BookService {

    public BookRepository bookRepository;
    private EmailService emailService;

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
        return bookRepository.getBookName(book);
    }


    // other methods which use EmailService


    public BookService(BookRepository bookRepository, EmailService emailService) {
        this.bookRepository = bookRepository;
        this.emailService = emailService;
    }
}
