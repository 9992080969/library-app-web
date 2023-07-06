package com.library.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

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
    private int people_id;

    @NotEmpty(message = "Пожалуйста, введите полное имя")
    @Size(max = 100, message = "Слишком длинное имя")
    private String fullName;

    @Min(value = 1900, message = "Год рождения должен быть больше 1900")
    @Max(value = 2023, message = "Год рождения должен быть меньше 2023")
    private int birthYear;

    @Override
    public String toString() {
        return people_id + ", " + fullName + ", " + birthYear;
    }
}