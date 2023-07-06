package com.library.app.dao;

import com.library.app.models.Person;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Доступ к данным
 *
 * @author Alexey Voronov on 02.07.2023
 */
@Component
@AllArgsConstructor
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM People", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM People WHERE people_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save (Person person){
        jdbcTemplate.update("INSERT INTO People(fullname, birthyear) VALUES (?,?)", person.getFullName(), person.getBirthYear());
    }

    public void update(int id, Person updatePerson){
        jdbcTemplate.update("UPDATE People SET fullname=?, birthyear=? WHERE people_id=?",  updatePerson.getFullName(), updatePerson.getBirthYear(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM People WHERE people_id=?", id);
    }
}