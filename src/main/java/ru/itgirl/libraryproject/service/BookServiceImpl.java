package ru.itgirl.libraryproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.libraryproject.dto.*;
import ru.itgirl.libraryproject.model.Author;
import ru.itgirl.libraryproject.model.Book;
import ru.itgirl.libraryproject.model.Genre;
import ru.itgirl.libraryproject.repository.BookRepository;
import ru.itgirl.libraryproject.repository.GenreRepository;

import java.util.Optional;

    @Service
    @RequiredArgsConstructor
    public class BookServiceImpl implements BookService {

        private final BookRepository bookRepository;
        private final GenreRepository genreRepository;
        @Override
        public BookDto getBookById(Long id) {
            Book book = (Book) bookRepository.findBookById(id).orElseThrow();
            return convertEntityToDto(book);
        }


        @Override
        public BookDto createBook(BookCreateDto bookCreateDto) {
            Genre genre = genreRepository.findById(bookCreateDto.getGenreId()).orElseThrow();
            Book book = convertDtoToEntity(bookCreateDto);
            book.setGenre(genre);
            Book savedBook = bookRepository.save(book);
            return convertEntityToDto(savedBook);
        }


        @Override
        public BookDto updateBookDto(BookUpdateDto bookUpdateDto) {
            Book book = bookRepository.findById(bookUpdateDto.getId()).orElseThrow();
            book.setName(bookUpdateDto.getName());


            Book savedBook = bookRepository.save(book);
            return convertEntityToDto(savedBook);

        }

        @Override
        public void deleteBook(Long id) {
            bookRepository.deleteById(id);
        }

        @Override
        public BookDto getByBookId(Long id) {
            Book book = bookRepository.findById(id).orElseThrow();
            return convertEntityToDto(book);
        }

        @Override
        public BookDto getByBookName(String name) {
            return getByBookName(name);
        }

   /*    @Override
    public Optional<Object> getBooksByAuthor(Author author) {
        return Optional.empty();
    }*/

    private Book convertDtoToEntity(BookCreateDto bookCreateDto) {
            return Book.builder()
                    .id(bookCreateDto.getId())
                    .name(bookCreateDto.getName())
                    .build();
        }
        private BookDto convertEntityToDto(Book book) {
            return BookDto.builder()
                    .id(book.getId())
                    .genre(book.getGenre().getName())
                    .name(book.getName())
                    .build();
        }



    }

