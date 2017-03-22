package com.beingjavaguys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.beingjavaguys.dao.ProjectDao;
import com.beingjavaguys.dao.UserDao;
import com.beingjavaguys.domain.Project;

public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectDao projectdao;

	@Override
	public List<Project> getProjectList(String projName) {
		// TODO Auto-generated method stub
		return projectdao.getProjectList(projName);
	}
	@Override
	public Project getProject(int projID) {
		// TODO Auto-generated method stub
		return projectdao.getProject(projID);
	}

	
}
