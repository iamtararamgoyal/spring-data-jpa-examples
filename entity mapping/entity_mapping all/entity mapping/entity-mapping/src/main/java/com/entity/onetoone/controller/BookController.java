package com.entity.onetoone.controller;

import com.entity.onetoone.entities.Book;
import com.entity.onetoone.repository.AutherRepository;
import com.entity.onetoone.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AutherRepository autherRepository;

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        try {
            Book save = bookRepository.save(book);
            return new ResponseEntity<>(save, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> books = (List<Book>) bookRepository.findAll();
            if (!books.isEmpty())
                return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
            else
                return new ResponseEntity<List<Book>>(books, HttpStatus.NOT_FOUND);

        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<Book>> getBook(@PathVariable("bookId") int bookId) {
        try {
            Optional<Book> books = bookRepository.findById(bookId);
            if (!books.isEmpty())
                return new ResponseEntity<List<Book>>(books.stream().collect(Collectors.toList()), HttpStatus.OK);
            else
                return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);

        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<List<Book>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Book> deleteBook(@PathVariable("bookId") int bookId) {
        try {
            Optional<Book> books = bookRepository.findById(bookId);
            if (!books.isEmpty()) {
                bookRepository.deleteById(bookId);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBooks(@PathVariable("bookId") int bookId, @RequestBody Book book) {

        try {
            Book books = bookRepository.findById(bookId).get();
            books.setAuther(book.getAuther());
            books.setName(book.getName());
            Book save = bookRepository.save(books);
            return new ResponseEntity<Book>(save, HttpStatus.CREATED);

        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
