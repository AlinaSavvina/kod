package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.AuthorCreateDto;
import ru.itgirl.libraryproject.dto.AuthorDto;
import ru.itgirl.libraryproject.dto.AuthorUpdateDto;


public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);

    AuthorDto updateAuthorDto(AuthorUpdateDto authorUpdateDto);

     void deleteAuthor(Long id) ;

}
