package com.sara.bookstore.controller;

import com.sara.bookstore.model.dto.PublisherDto;
import com.sara.bookstore.service.PublicationService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("publication/")
@AllArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;

    @GetMapping
    public ResponseEntity<List<PublisherDto>> getBookList() {
        return ResponseEntity.ok( publicationService.getPublicationList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> getPublicationById(@PathVariable Long id) {
        return ResponseEntity.ok( publicationService.getPublicationById(id));
    }

    @GetMapping("book/{id}")
    public ResponseEntity<PublisherDto> getBookByPublication(@PathVariable Long id) {
        return ResponseEntity.ok((PublisherDto) publicationService.getPublisherBooks(id));
    }

    @PostMapping
    public ResponseEntity<Void> createPublication(@RequestBody PublisherDto publisherDto) {
        publicationService.createPublisher(publisherDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        publicationService.removePublisher(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePublication(@PathVariable Long id,
                                                  @RequestBody PublisherDto updatedPublisher) {
        publicationService.updatePublication(id, updatedPublisher);
        return ResponseEntity.ok().build();
    }

}
