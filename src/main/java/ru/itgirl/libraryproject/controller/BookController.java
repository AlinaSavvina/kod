package ru.itgirl.libraryproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itgirl.libraryproject.dto.*;
import ru.itgirl.libraryproject.service.BookService;

@RestController
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;

    @GetMapping("/book")
    BookDto getBookByName(@RequestParam("name") String name) {
        return bookService.getByBookName(name);
    }
    @PostMapping("/book/create")
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto) {
        return bookService.createBook(bookCreateDto);
    }
    @PutMapping("/book/update")
    BookDto updateBook(@RequestBody BookUpdateDto bookUpdateDto) {

        return bookService.updateBookDto(bookUpdateDto);
    }
    @DeleteMapping("/book/delete/{id}")
    void updateBook(@PathVariable("id") Long id) {

        bookService.deleteBook(id);
    }
}
