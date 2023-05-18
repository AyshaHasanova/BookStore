package com.sara.bookstore.mapper;

import com.sara.bookstore.dao.entity.ReviewEntity;

import com.sara.bookstore.model.dto.ReviewDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends EntityMapper<ReviewDto, ReviewEntity> {
}
