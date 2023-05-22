package com.sara.bookstore.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    private String name;
    private String surname;
    private String email;
    private String phone;
    private List<Long> bookIdList;

}
