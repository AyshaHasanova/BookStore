package com.sara.bookstore.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "phone",nullable = false, unique = true)
    private String phone;

    @ManyToMany(mappedBy = "authors")
    private List<BookEntity> bookEntityList;
}

