package com.example.springseminar5example2.controllers;

import com.example.springseminar5example2.models.Book;
import com.example.springseminar5example2.models.Reader;
import com.example.springseminar5example2.repositories.BookRepository;
import com.example.springseminar5example2.repositories.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}/reader/{readerId}")
    public ResponseEntity<Book> updateBook(@PathVariable long id, @PathVariable long readerId, @RequestBody Book book) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        Optional<Reader> readerOptional = readerRepository.findById(readerId);

        if (bookOptional.isPresent() && readerOptional.isPresent()) {
            Book book1 = bookOptional.get();
            Reader reader = readerOptional.get();
            book1.setReader(reader);
            bookRepository.save(book);
            return ResponseEntity.ok(book1);
        }
        return ResponseEntity.notFound().build();
    }

}