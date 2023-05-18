package com.sara.bookstore.mapper;

import com.sara.bookstore.dao.entity.*;
import com.sara.bookstore.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookStoreMapper extends EntityMapper<BookDto, BookEntity> {
    BookStoreMapper BOOK_STORE_MAPPER = Mappers.getMapper(BookStoreMapper.class);

    BookEntity toBookEntity(List<AuthorEntity> authors,
                            List<PublisherEntity> publishers,
                            BookDto bookDto);


//    BookEntity toBookEntity(BookDto bookDto);

//    BookDto toBookDto(BookEntity bookEntity);
//
//    List<BookDto> toBookDtoList(List<BookEntity> bookEntityList);
//
//    AuthorEntity toAuthorEntity(AuthorDto1 authorDto);
//
//    AuthorDto toAuthorDto(AuthorEntity authorEntity);
//
//    List<AuthorDto> toAuthorDtoList(List<AuthorEntity> authorEntityList);
//
//    ReviewDto toReviewDto(ReviewEntity reviewEntity);
//
//    List<ReviewDto> toReviewDtoList(List<ReviewEntity> reviewEntityList);
//
//    PublisherEntity toPublisherEntity(PublisherDto publisherDto);
//
//    PublisherDto toPublisherDto(PublisherEntity publisherEntity);
//
//    List<PublisherDto> toPublisherDtoList(List<PublisherEntity> publisherEntityList);
}



