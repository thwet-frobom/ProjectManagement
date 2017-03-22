package com.beingjavaguys.services;

import java.util.List;

import com.beingjavaguys.domain.Project;

public interface ProjectService {

	public List<Project> getProjectList(String projName);
	
	public Project getProject(int projID);
}
