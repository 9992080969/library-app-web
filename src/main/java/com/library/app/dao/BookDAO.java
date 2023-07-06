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

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }
}