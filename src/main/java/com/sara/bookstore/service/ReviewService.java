package com.sara.bookstore.service;

import com.sara.bookstore.dao.entity.ReviewEntity;
import com.sara.bookstore.dao.repository.ReviewRepository;
import com.sara.bookstore.exception.Error;
import com.sara.bookstore.exception.NotFoundException;
import com.sara.bookstore.mapper.BookStoreMapper;
import com.sara.bookstore.mapper.ReviewMapper;
import com.sara.bookstore.model.dto.ReviewDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    public List<ReviewDto> getReviewList(){
        List<ReviewEntity> reviewEntityList= reviewRepository.findAll();
        return reviewMapper.toDto(reviewEntityList);
    }

    public ReviewDto getReviewById(Long Id) {
        ReviewEntity reviewEntity = reviewRepository.findById(Id).orElseThrow(
                () -> new NotFoundException(
                        Error.REVIEW_NOT_FOUND_ERROR_CODE,
                        Error.REVIEW_NOT_FOUND_ERROR_MESSAGE));
        return reviewMapper.toDto( reviewEntity);
    }
}
