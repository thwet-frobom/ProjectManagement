package com.beingjavaguys.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.beingjavaguys.domain.Project;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.jdbc.ProjectRowMapper;
import com.beingjavaguys.jdbc.UserRowMapper;

public class ProjectDaoImpl implements ProjectDao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public List<Project> getProjectList(String projName) {
		// TODO Auto-generated method stub
		
		System.out.println("1st Enter in method:");
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
			String SQL = "select * from project";
		     List<Project> resultProject = new ArrayList<Project>();
		     
		      List <Project> projects = jdbcTemplate.query(SQL, 
		                                new ProjectRowMapper());
		      System.out.println("Project size is:"+projects.size());
		      
		      for(int i = 0; i < projects.size(); i++){
		    	  System.out.println("Loop Enter in method:");
		    	  Project pName = projects.get(i);
		    	  System.out.println("Project Name is:"+pName);
			      String projectName = pName.getProjectname();
			      System.out.println("2nd Project Name is:"+projectName);
			      System.out.println("O pname length:"+projName.length());
			      System.out.println("DB pname length :"+projectName.length());
			      
			      if(projName.length()<=projectName.length()){
			    	  System.out.println("2st Enter in method:");
			    	  if(projName.toLowerCase().contains(projectName.toLowerCase())){
			    		  System.out.println("3st Enter in method:");
			    		  pName.setProjectname(projectName);
			    		  resultProject.add(pName);
			    	  }
			      }
		      }
		     
		      return resultProject;
	}

	/* (non-Javadoc)
	 * @see com.beingjavaguys.dao.ProjectDao#getProject(int)
	 */
	@Override
	public Project getProject(int projID) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select * from Project where projectid = ?";
		Project project = jdbcTemplate.queryForObject(sql, 
                new Object[]{projID}, new ProjectRowMapper());
		return project;
	}
	
}
