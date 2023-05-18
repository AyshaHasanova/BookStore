package com.sara.bookstore.controller;

import com.sara.bookstore.model.dto.ReviewDto;
import com.sara.bookstore.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("review/")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getReviewList() {
        return ResponseEntity.ok(reviewService.getReviewList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok( reviewService.getReviewById(id));
    }

}
