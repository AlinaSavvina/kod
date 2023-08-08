package ru.itgirl.libraryproject.service;

import ru.itgirl.libraryproject.dto.*;
import ru.itgirl.libraryproject.model.Author;
import java.util.Optional;

public interface BookService {
    BookDto getBookById(Long id);


    BookDto createBook(BookCreateDto bookCreateDto);

    BookDto updateBookDto(BookUpdateDto bookUpdateDto);

    void deleteBook(Long id) ;

    BookDto getByBookId(Long id);

    BookDto getByBookName(String name);


    //Optional<Object> getBooksByAuthor(Author author);
}
