package com.krisven;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportRowMapper implements RowMapper<Report> {

    @Override
    public Report mapRow(ResultSet resultSet, int i) throws SQLException {
        Report report = new Report();
        report.setDate(resultSet.getString("date"));
        report.setImpressions(resultSet.getString("impressions"));
        report.setClicks(resultSet.getString("clicks"));
        report.setEarning(resultSet.getString("earning"));
        System.out.println(report.toString());
        return report;
    }

}
