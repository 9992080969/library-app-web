package com.library.app.models;

/**
 * Модель книги
 *
 * @author Alexey Voronov on 01.07.2023
 */
public class Book {
    private String title;
    private String author;
    private int bookYear;


    public Book(String title, String author, int bookYear) {
        this.title = title;
        this.author = author;
        this.bookYear = bookYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }
}