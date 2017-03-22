package com.beingjavaguys.dao;

import java.util.List;

import com.beingjavaguys.domain.*;

public interface ProjectDao {

	public List<Project> getProjectList(String projName);
	
	public Project getProject(int projID);
}
