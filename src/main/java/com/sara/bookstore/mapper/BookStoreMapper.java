package com.sara.bookstore.mapper;

import com.sara.bookstore.dao.entity.AuthorEntity;
import com.sara.bookstore.dao.entity.BookEntity;
import com.sara.bookstore.dao.entity.PublisherEntity;
import com.sara.bookstore.dao.entity.ReviewEntity;
import com.sara.bookstore.model.dto.AuthorDto;
import com.sara.bookstore.model.dto.BookDto;
import com.sara.bookstore.model.dto.PublisherDto;
import com.sara.bookstore.model.dto.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookStoreMapper {
    BookStoreMapper BOOK_STORE_MAPPER = Mappers.getMapper(BookStoreMapper.class);

    BookEntity toBookEntity(BookDto bookDto);

    BookDto toBookDto(BookEntity bookEntity);

    List<BookDto> toBookDtoList(List<BookEntity> bookEntityList);

    AuthorEntity toAuthorEntity(AuthorDto authorDto);

    AuthorDto toAuthorDto(AuthorEntity authorEntity);

    List<AuthorDto> toAuthorDtoList(List<AuthorEntity> authorEntityList);

    ReviewEntity toReviewEntity(ReviewDto reviewDto);

    ReviewDto toReviewDto(ReviewEntity reviewEntity);

    List<ReviewDto> toReviewDtoList(List<ReviewEntity> reviewEntityList);

    PublisherEntity toPublisherEntity(PublisherDto publisherDto);

    PublisherDto toPublisherDto(PublisherEntity publisherEntity);

    List<PublisherDto> toPublisherDtoList(List<PublisherEntity> publisherEntityList);

}
