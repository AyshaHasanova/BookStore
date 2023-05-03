package com.sara.bookstore.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="review")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reviewer")
    private String reviewer;

    @Column(name = "note")
    private String note;

    @ManyToOne
    private BookEntity bookEntity;

}
