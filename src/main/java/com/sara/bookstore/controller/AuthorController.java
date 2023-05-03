package com.sara.bookstore.controller;

import com.sara.bookstore.model.dto.AuthorDto;
import com.sara.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authors/")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAutorList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

    @GetMapping("book/{id}")
    public ResponseEntity<AuthorDto> getBookByAuthor(@PathVariable Long id) {
        return ResponseEntity.ok((AuthorDto) authorService.getAuthorBooks(id));
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.removeAuthor(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long id,
                                             @RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(id,String.valueOf(authorDto));
        return ResponseEntity.ok().build();
    }
}






