package com.codesnippet.BookApplication.Service;

import com.codesnippet.BookApplication.Entity.Book;
import com.codesnippet.BookApplication.Repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional class level transaction
//Transaction will apply only for public methods
public class BookService {

    private final BookRepository bookRepository;
    private static  final Logger logger= LoggerFactory.getLogger(BookService.class);
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    //Transaction is applicable only for public methods
    //If the method which is calling this method if it has  transactional annotation then
    //this method will join same transaction or else it will create a new .
    // Default Transaction Propagation is Required which I explained above
    public Book addBook(Book book) {
        logger.info("addBook");
        logger.error("book id is {}", book.getId());
        logger.warn("Book id is {}", book.getId());
        logger.debug("Book id is {}", book.getId());
        logger.trace("Book id is {}", book.getId());
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
