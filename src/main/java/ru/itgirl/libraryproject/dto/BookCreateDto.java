package ru.itgirl.libraryproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookCreateDto {
    private Long id;
    private String name;
    private Long genreId;

    public Long getGenreId() {


        return genreId;}
}
