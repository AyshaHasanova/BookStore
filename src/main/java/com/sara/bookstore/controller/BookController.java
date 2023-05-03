package com.sara.bookstore.controller;

import com.sara.bookstore.model.dto.BookDto;
import com.sara.bookstore.model.enums.Language;
import com.sara.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("book/")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getBookList() {
        return ResponseEntity.ok(bookService.getBookList());
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @GetMapping("book/{id}")
    public ResponseEntity<BookDto> reserveBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.reserveBook(id));
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long id,
                                              @RequestBody BookDto bookDto) {
        return ResponseEntity.ok(bookService.updateBook(id, bookDto));
    }

    @DeleteMapping({"{id}"})
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<BookDto> getBooksByName(@PathVariable String name) {
        return ResponseEntity.ok((BookDto) bookService.getBooksByName(name));
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<BookDto>> getBooksByLanguage(@PathVariable Language language) {
        return ResponseEntity.ok(bookService.getBooksByLanguage(language));
    }

    @GetMapping("/publicationDate/")
    public ResponseEntity<List<BookDto>> getBooksByPublicationDate(@PathVariable LocalDate publicationDate) {
        return ResponseEntity.ok(bookService.getBooksByPublicationDate(publicationDate));
    }
}
