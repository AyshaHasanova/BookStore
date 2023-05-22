package com.sara.bookstore.model.dto.response;

import com.sara.bookstore.model.dto.BookDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublisherResponseDto {
    private Long id;
    private String name;
    private String address;
    private List<BookResponseDto> bookIdList;
}
