package com.library.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Модель книги
 *
 * @author Alexey Voronov on 01.07.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    @NotEmpty (message = "Пожалуйста, введите полное название книги")
    @Size(max = 200, message = "Название книги должно занимать менее 200 символов")
    private String title;
    @NotEmpty(message = "Пожалуйста, введите полное имя автора")
    @Size(max = 100, message = "Слишком длинное имя")
    private String author;
    @Min(value = 0, message = "Год создания книги должен быть больше 0")
    @Max(value = 2023, message = "Год создания книги должен быть меньше 2023")
    private int bookYear;
}