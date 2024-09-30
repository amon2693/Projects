package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> person = new ArrayList<>();

        String sql = "SELECT * " + "FROM person;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()) {
            Person people = mapRowToPerson(rowSet);
            person.add(people);

        }
        return person;

    }

    @Override
    public Person getPersonById(int personId) {
        Person person = null;
        String sql = "SELECT * " +
                "FROM person " +
                "WHERE person_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, personId);
        if (rowSet.next()) {
            person = mapRowToPerson(rowSet);
        }

        return person;
    }


    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> person = new ArrayList<>();
        SqlRowSet rowSet;

        if (useWildCard) {
            String sql = "SELECT * " +
                    "FROM person " +
                    "WHERE person_name ILIKE ?;";
            rowSet = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
        } else {
            String sql = "SELECT * " +
                    "FROM person " +
                    "WHERE person_name ILIKE ?;";
            rowSet = jdbcTemplate.queryForRowSet(sql, name);
        }

        while (rowSet.next()) {
            Person people = mapRowToPerson(rowSet);
            person.add(people);
        }

        return person;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        return null;
    }

    private Person mapRowToPerson(SqlRowSet rowSet) {
        Person person = new Person();
        person.setId(rowSet.getInt("person_id"));
        person.setName(rowSet.getString("person_name"));
        person.setBirthday(rowSet.getDate("birthday").toLocalDate());
        person.setDeathDate(rowSet.getDate("deathday").toLocalDate());
        person.setBiography(rowSet.getString("biography"));
        person.setProfilePath(rowSet.getString("profile_path"));
        person.setHomePage(rowSet.getString("home_page"));
        return person;
    }
}

