package com.sara.bookstore.dao.repository;

import com.sara.bookstore.dao.entity.BookEntity;
import com.sara.bookstore.model.enums.Language;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByName(String name);

    List<BookEntity> findByLanguage(Language language);

    List<BookEntity> findByPublicationDate(LocalDate publicationDate);

    List<BookEntity> findAll(Specification<BookEntity> specification);
}

