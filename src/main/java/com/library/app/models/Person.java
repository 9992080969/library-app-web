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
 * Сущность пользователя
 *
 * @author Alexey Voronov on 01.07.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Person {
    private int id;
    @NotEmpty(message = "Пожалуйста, введите полное имя")
    @Size(max = 100, message = "Слишком длинное имя")
    private String fullName;
    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    @Max(value = 2023, message = "Год рождения должен быть меньше 2023")
    private int birthYear;
}