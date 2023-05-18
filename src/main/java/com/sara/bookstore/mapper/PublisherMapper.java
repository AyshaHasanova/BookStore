package com.sara.bookstore.mapper;

import com.sara.bookstore.dao.entity.PublisherEntity;
import com.sara.bookstore.model.dto.PublisherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper extends EntityMapper<PublisherDto, PublisherEntity>{
}
