package com.sara.bookstore.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @ManyToMany(mappedBy = "publishers")
    private List<BookEntity> bookEntityList;

}
