package com.library.app.dao;

import com.library.app.models.Book;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Alexey Voronov on 06.07.2023
 */
@Component
@AllArgsConstructor
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE books_id=?",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book book) {
        jdbcTemplate.update("INSERT INTO books(title, author, bookyear) VALUES (?,?,?)",
                book.getTitle(), book.getAuthor(), book.getBookYear());
    }

    public void update(int id, Book updateBook) {
        jdbcTemplate.update("UPDATE books SET title=?, author=?, bookyear=? WHERE books_id=?",
                updateBook.getTitle(), updateBook.getAuthor(), updateBook.getBookYear(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM books WHERE books_id=?", id);
    }
}