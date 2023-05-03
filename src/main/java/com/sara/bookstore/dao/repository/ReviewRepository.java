package com.sara.bookstore.dao.repository;

import com.sara.bookstore.dao.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
}
