package com.sara.bookstore.service;
import com.sara.bookstore.dao.entity.PublisherEntity;
import com.sara.bookstore.dao.repository.PublicationRepository;
import com.sara.bookstore.exception.Error;
import com.sara.bookstore.exception.NotFoundException;
import com.sara.bookstore.mapper.BookStoreMapper;
import com.sara.bookstore.mapper.PublisherMapper;
import com.sara.bookstore.model.dto.BookDto;
import com.sara.bookstore.model.dto.PublisherDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final BookStoreMapper bookStoreMapper;
    private final PublisherMapper publisherMapper;

    public List<PublisherDto> getPublicationList(){
        List<PublisherEntity> publicationEntityList= publicationRepository.findAll();
        return publisherMapper.toDto(publicationEntityList);
    }

    public PublisherDto getPublicationById(Long Id) {
        PublisherEntity publisherEntity = publicationRepository.findById(Id).orElseThrow(
                () -> new NotFoundException(
                        Error.PUBLISHER_NOT_FOUND_ERROR_CODE,
                        Error.PUBLISHER_NOT_FOUND_ERROR_MESSAGE));
        return publisherMapper.toDto(publisherEntity);
    }

    public void createPublisher( PublisherDto publisherDto) {
        PublisherEntity  publisherEntity = publisherMapper.toEntity(publisherDto);
        publicationRepository.save( publisherEntity);
    }

    public void removePublisher(Long Id) {
        PublisherEntity  publisherEntity = publicationRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException(
                        Error.PUBLISHER_NOT_FOUND_ERROR_CODE,
                        Error.PUBLISHER_NOT_FOUND_ERROR_MESSAGE));
        publicationRepository.delete(publisherEntity);
    }

    public void updatePublication(Long id, PublisherDto updatedPublisher) {
        PublisherEntity publisherEntity = publicationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(
                        Error.PUBLISHER_NOT_FOUND_ERROR_CODE,
                        Error.PUBLISHER_NOT_FOUND_ERROR_MESSAGE));
        publisherEntity.setName(updatedPublisher.getName());
        publicationRepository.save(publisherEntity);
    }

    public List<BookDto> getPublisherBooks(Long Id) {
        PublisherEntity  publisherEntity = publicationRepository.findById(Id).orElseThrow(
                () -> new NotFoundException(Error.PUBLISHER_NOT_FOUND_ERROR_CODE,
                        Error.PUBLISHER_NOT_FOUND_ERROR_MESSAGE));
        return bookStoreMapper.toDto(publisherEntity.getBookEntityList());
    }

}
