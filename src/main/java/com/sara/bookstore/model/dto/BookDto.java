package com.sara.bookstore.model.dto;

import com.sara.bookstore.model.enums.Currency;
import com.sara.bookstore.model.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String name;
    private Integer price;
    private Integer quantity;
    private LocalDate publicationDate;
    private Language language;
    private Currency currency;
    private String review;
    private List<Long> authorIdList;
    private List<Long> publisherIdList;
}
