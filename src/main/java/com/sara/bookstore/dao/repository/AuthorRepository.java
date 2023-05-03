package com.sara.bookstore.dao.repository;

import com.sara.bookstore.dao.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    List<AuthorEntity> findAllByIdIn(List<Long> authorIdList);
}
