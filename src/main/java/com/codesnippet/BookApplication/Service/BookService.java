package com.codesnippet.BookApplication.Service;

import com.codesnippet.BookApplication.Entity.Book;
import com.codesnippet.BookApplication.Repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional class level transaction
//Transaction will apply only for public methods
public class BookService {

    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    //Transaction is applicable only for public methods
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
