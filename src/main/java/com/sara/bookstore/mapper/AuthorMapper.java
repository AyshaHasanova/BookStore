package com.sara.bookstore.mapper;

import com.sara.bookstore.dao.entity.AuthorEntity;
import com.sara.bookstore.dao.entity.BookEntity;
import com.sara.bookstore.model.dto.AuthorDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends EntityMapper<AuthorDto, AuthorEntity> {

    BookEntity toEntity(List<BookEntity> authorEntityList, AuthorDto bookDto);
}
