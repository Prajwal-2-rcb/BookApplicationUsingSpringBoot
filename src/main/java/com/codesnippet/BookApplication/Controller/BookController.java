package com.codesnippet.BookApplication.Controller;

import com.codesnippet.BookApplication.Entity.Book;
import com.codesnippet.BookApplication.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book savebook=bookService.addBook(book);
        return ResponseEntity.ok(savebook);
    }

    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name)
    {
       Book getBook= bookService.getBookByName(name);
       return ResponseEntity.ok(getBook);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book)
    {
        Book updatedbook=bookService.updateBook(book);
        return ResponseEntity.ok(updatedbook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id)
    {
        String s=bookService.deleteBook(id);
        return ResponseEntity.ok(s);
    }


}
