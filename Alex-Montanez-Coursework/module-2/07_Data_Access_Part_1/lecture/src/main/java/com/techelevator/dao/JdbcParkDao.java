package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        int count = 0;

        String sql = "SELECT COUNT(*) AS count FROM park;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        if (rowSet.next()) {
            count = rowSet.getInt("count");
        }

        return count;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        LocalDate oldest = null;

        String sql = "SELECT MIN(date_established) AS oldest FROM park;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        if (rowSet.next()) {
            Date date = rowSet.getDate("oldest");
            if (date != null) {
                oldest = date.toLocalDate();
            }
        }
        return oldest;
    }
    
    @Override
    public double getAverageParkArea() {
        double average = 0.0;

        String sql = "SELECT AVG(area) AS average FROM park;";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);

        if(rowSet.next()) {
            average = rowSet.getDouble("average");
        }
        return average;
    }
    
    @Override
    public List<String> getParkNames() {
        return new ArrayList<>();
    }
    
    @Override
    public Park getRandomPark() {
        return new Park();
    }

    @Override
    public List<Park> getParksWithCamping() {
        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {
        return new Park();
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        return new ArrayList<>();
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) { return new ArrayList<>(); }

    private Park mapRowToPark(SqlRowSet rowSet) {
        return new Park();
    }
}
