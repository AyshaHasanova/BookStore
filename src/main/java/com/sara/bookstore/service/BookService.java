package com.sara.bookstore.service;

import com.sara.bookstore.dao.entity.BookEntity;
import com.sara.bookstore.dao.repository.AuthorRepository;
import com.sara.bookstore.dao.repository.BookRepository;
import com.sara.bookstore.dao.repository.PublicationRepository;
import com.sara.bookstore.exception.NotEnoughStockException;
import com.sara.bookstore.exception.NotFoundException;
import com.sara.bookstore.model.dto.BookDto;
import com.sara.bookstore.specification.BookSpecification;
import com.sara.bookstore.model.dto.BookFilter;
import com.sara.bookstore.mapper.BookStoreMapper;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.sara.bookstore.exception.Error;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookStoreMapper    bookStoreMapper;
    private final AuthorRepository authorRepository;
    private final PublicationRepository publisherRepository;


    public List<BookDto> getBookList() {
        List<BookEntity> bookEntityList = bookRepository.findAll();
        return bookStoreMapper.toDto(bookEntityList);
    }

    public BookDto getBookById(Long bookId) {
        BookEntity bookEntity = bookRepository.findById(bookId).orElseThrow(
                () -> new NotFoundException(
                        Error.BOOK_NOT_FOUND_ERROR_CODE,
                        Error.BOOK_NOT_FOUND_ERROR_MESSAGE)
        );
        return bookStoreMapper.toDto(bookEntity);
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
        bookRepository.save(bookEntity);
        return bookStoreMapper.toDto(bookEntity);
    }

    public void createBook(BookDto bookDto) {
        var authorEntityList = authorRepository.findAllByIdIn(bookDto.getAuthorIdList());
        var publisherEntityList = publisherRepository.findAllByIdIn(bookDto.getPublisherIdList());

        BookEntity bookEntity = bookStoreMapper.toBookEntity(authorEntityList, publisherEntityList, bookDto);
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
        return bookStoreMapper.toDto(updatedBookEntity);
    }

    public List<BookDto> findBooks(BookFilter filter) {
        Specification<BookEntity> specification = new BookSpecification(filter);
        System.out.println("Service");
        List<BookEntity> bookEntities = bookRepository.findAll(specification);
        return bookStoreMapper.toDto(bookEntities);
    }
}


