package com.beingjavaguys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beingjavaguys.domain.*;

public class ProjectRowMapper implements RowMapper<Project>{

	@Override
	public Project mapRow(ResultSet resultSet, int line) throws SQLException {
		ProjectExtractor projectExtractor = new ProjectExtractor();
		return projectExtractor.extractData(resultSet);
	}

}
