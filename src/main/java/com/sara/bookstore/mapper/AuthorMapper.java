package com.sara.bookstore.mapper;

import com.sara.bookstore.dao.entity.AuthorEntity;
import com.sara.bookstore.model.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends EntityMapper<AuthorDto, AuthorEntity> {

}
