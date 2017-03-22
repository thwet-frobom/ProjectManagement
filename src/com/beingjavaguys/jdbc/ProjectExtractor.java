package com.beingjavaguys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.beingjavaguys.domain.*;

public class ProjectExtractor implements ResultSetExtractor<Project>{

	@Override
	public Project extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub

		Project project = new Project();
		project.setProjectid(resultSet.getInt("projectid"));
		project.setProjectname(resultSet.getString("projectname"));
		project.setProjectstartdate(resultSet.getString("projectstartdate"));
		project.setProjectenddate(resultSet.getString("projectenddate"));
		project.setTeamid(resultSet.getInt("teamid"));
		
		return project;
	}

}
