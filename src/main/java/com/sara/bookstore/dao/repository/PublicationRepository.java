package com.sara.bookstore.dao.repository;

import com.sara.bookstore.dao.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<PublisherEntity, Long> {
    List<PublisherEntity> findAllByIdIn(List<Long> publisherIdList);
}
