package com.sara.bookstore.service;

import com.sara.bookstore.dao.entity.AuthorEntity;

import com.sara.bookstore.dao.repository.AuthorRepository;
import com.sara.bookstore.exception.Error;
import com.sara.bookstore.exception.NotFoundException;
import com.sara.bookstore.mapper.AuthorMapper;
import com.sara.bookstore.mapper.BookStoreMapper;
import com.sara.bookstore.model.dto.AuthorDto;
import com.sara.bookstore.model.dto.BookDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookStoreMapper bookStoreMapper;
    private final AuthorMapper authorMapper ;

    public List<AuthorDto> getAutorList() {
        return authorMapper.toDto(authorRepository.findAll());
    }

    public AuthorDto getAuthorById(Long Id) {
        AuthorEntity authorEntity = authorRepository.findById(Id).orElseThrow(
                () -> new NotFoundException(Error.AUTHOR_NOT_FOUND_ERROR_CODE,
                        Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        return authorMapper.toDto(authorEntity);
    }

    public void createAuthor(AuthorDto authorDto) {
        AuthorEntity authorEntity = authorMapper.toEntity(authorDto);
        authorRepository.save(authorEntity);

    }

    public void removeAuthor(Long Id) {
        AuthorEntity authorEntity = authorRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException(
                        Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        authorRepository.delete(authorEntity);
    }

    public void updateAuthor(Long id, String newName) {
        AuthorEntity authorEntity = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Error.AUTHOR_NOT_FOUND_ERROR_CODE,
                        Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        authorEntity.setName(newName);
        authorRepository.save(authorEntity);
    }

    public List<BookDto> getAuthorBooks(Long Id) {
        AuthorEntity authorEntity = authorRepository.findById(Id).orElseThrow(
                () -> new NotFoundException(Error.AUTHOR_NOT_FOUND_ERROR_CODE,
                        Error.AUTHOR_NOT_FOUND_ERROR_MESSAGE));
        return bookStoreMapper.toDto(authorEntity.getBookEntityList());
    }

}
