package com.sara.bookstore.specification;

import com.sara.bookstore.dao.entity.BookEntity;
import com.sara.bookstore.model.dto.BookFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<BookEntity> {

    private final BookFilter filter;

    public BookSpecification(BookFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<BookEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (!ObjectUtils.isEmpty(filter.getId())) {
            predicates.add(criteriaBuilder.equal(root.get("id"), filter.getId()));
        }
        if (!ObjectUtils.isEmpty(filter.getName())) {
            predicates.add(criteriaBuilder.equal(root.get("name"), filter.getName()));
        }
        if (!ObjectUtils.isEmpty(filter.getPublicationDate())) {
            predicates.add(criteriaBuilder.equal(root.get("publicationDate"), filter.getPublicationDate()));
        }
        if (!ObjectUtils.isEmpty(filter.getLanguages())) {
            predicates.add(root.get("language").in(filter.getLanguages()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}


