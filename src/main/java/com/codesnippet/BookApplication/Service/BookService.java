package com.codesnippet.BookApplication.Service;

import com.codesnippet.BookApplication.Entity.Book;
import com.codesnippet.BookApplication.Repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;

    }


    public Book getBookByName(String name) {

       return  bookRepository.findByTitle(name);

    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }
}
