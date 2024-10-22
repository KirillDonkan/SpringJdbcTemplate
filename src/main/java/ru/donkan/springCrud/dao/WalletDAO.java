package ru.donkan.springCrud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.donkan.springCrud.models.Person;
import java.util.List;


@Component
public class WalletDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WalletDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int uuid) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE uuid=?", new Object[]{uuid},
                        new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, balance, email) VALUES(?, ?, ?)",
                /*person.getUuid(),*/ person.getName(), person.getBalance(), person.getEmail());
    }

    public void update(int uuid, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, balance=?, email=? WHERE uuid=?", updatedPerson.getName(),
                updatedPerson.getBalance(), updatedPerson.getEmail(), uuid);
    }

    public void delete(int uuid) {
        jdbcTemplate.update("DELETE FROM Person WHERE uuid=?", uuid);
    }
}
