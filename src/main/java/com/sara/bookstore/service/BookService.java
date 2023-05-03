package com.sara.bookstore.service;

import com.sara.bookstore.dao.entity.AuthorEntity;
import com.sara.bookstore.dao.entity.BookEntity;
import com.sara.bookstore.dao.repository.AuthorRepository;
import com.sara.bookstore.dao.repository.BookRepository;
import com.sara.bookstore.dao.repository.PublicationRepository;
import com.sara.bookstore.exception.NotEnoughStockException;
import com.sara.bookstore.exception.NotFoundException;
import com.sara.bookstore.mapper.BookStoreMapper;
import com.sara.bookstore.model.dto.BookDto;
import com.sara.bookstore.model.enums.Language;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.sara.bookstore.exception.Error;

import java.time.LocalDate;
import java.util.List;


@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookStoreMapper bookStoreMapper;
    private final AuthorRepository authorRepository;


    public List<BookDto> getBookList() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookStoreMapper.toBookDtoList(bookEntityList);
    }

    public BookDto getBookById(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundException(
                        Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE)
        );
        return bookStoreMapper.toBookDto(bookEntity);
    }

    public BookDto reserveBook(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundException(
                        Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        if (bookEntity.getQuantity() == 0) {
            throw new NotEnoughStockException(
                    Error.NOT_ENOUGH_STOCK_ERROR_CODE,
                    Error.NOT_ENOUGH_STOCK_ERROR_MESSAGE);
        }
        bookEntity.setQuantity(bookEntity.getQuantity() - 1);
        return bookStoreMapper.toBookDto(bookEntity);
    }


    public void createBook(BookDto bookDto) {
        BookEntity bookEntity = bookStoreMapper.toBookEntity(bookDto);
        List<AuthorEntity> authorEntityList = authorRepository.findAllByIdIn(bookDto.getAuthorIdList());
        bookEntity.setAuthors(authorEntityList);
        bookRepository.save(bookEntity);

    }

    public void removeBook(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(
                        Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        bookRepository.delete(bookEntity);
    }

    public BookDto updateBook(Long id, BookDto bookDto) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE));
        bookEntity.setName(bookDto.getName());
        bookEntity.setLanguage(bookDto.getLanguage());
        bookEntity.setPrice(bookDto.getPrice());
        bookEntity.setCurrency(bookDto.getCurrency());
        bookEntity.setPublicationDate(bookDto.getPublicationDate());
        BookEntity updatedBookEntity = bookRepository.save(bookEntity);
        return bookStoreMapper.toBookDto(updatedBookEntity);
    }

    public List<BookDto> getBooksByName(String name) {
        List<BookEntity> bookEntities = bookRepository.findByName(name);
        return bookStoreMapper.toBookDtoList(bookEntities);
    }

    public List<BookDto> getBooksByLanguage(Language language) {
        List<BookEntity> bookEntities = bookRepository.findByLanguage(language);
        return bookStoreMapper.toBookDtoList(bookEntities);
    }

    public List<BookDto> getBooksByPublicationDate(LocalDate publicationDate) {
        List<BookEntity> bookEntities = bookRepository.findByPublicationDate(publicationDate);
        return bookStoreMapper.toBookDtoList(bookEntities);
    }
    
}


