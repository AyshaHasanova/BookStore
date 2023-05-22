package com.sara.bookstore.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<BookResponseDto> bookIdList;
}
