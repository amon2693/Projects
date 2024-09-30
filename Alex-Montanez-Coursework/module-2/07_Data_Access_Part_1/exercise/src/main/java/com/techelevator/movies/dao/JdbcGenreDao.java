package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcGenreDao implements GenreDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcGenreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Genre> getGenres() {
        List<Genre> genre = new ArrayList<>();

        String sql = "SELECT * " + "FROM genre;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        while (rowSet.next()) {
            Genre genres = mapRowToGenre(rowSet);
            genre.add(genres);

        }
        return genre;
    }

    @Override
    public Genre getGenreById(int genreId) {
        Genre genre = null;
        String sql = "SELECT * " +
                "FROM genre " +
                "WHERE genre_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, genreId);
        if (rowSet.next()) {
            genre = mapRowToGenre(rowSet);
        }

        return genre;
    }

    @Override
    public List<Genre> getGenresByName(String name, boolean useWildCard) {
        List<Genre> genre = new ArrayList<>();
        SqlRowSet rowSet;

        if (useWildCard) {
            String sql = "SELECT * " +
                    "FROM genre " +
                    "WHERE genre_name ILIKE ?;";
            rowSet = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
        } else {
            String sql = "SELECT * " +
                    "FROM genre " +
                    "WHERE genre_name ILIKE ?;";
            rowSet = jdbcTemplate.queryForRowSet(sql, name);
        }

        while (rowSet.next()) {
            Genre genres = mapRowToGenre(rowSet);
            genre.add(genres);
        }

        return genre;
    }




    private Genre mapRowToGenre(SqlRowSet rowSet) {
        Genre genre = new Genre();
        genre.setId(rowSet.getInt("genre_id"));
        genre.setName(rowSet.getString("genre_name"));
        return genre;
    }
}
