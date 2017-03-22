package com.beingjavaguys.domain;

public class Project {

	int projectid;
	String projectname;
	String projectstartdate;
	String projectenddate;
	int teamid;
	
	public Project(){
		
	}
	public Project(int projectid, String projectname, String projectstartdate, String projectenddate, int teamid){
		this.projectid = projectid;
		this.projectname = projectname;
		this.projectstartdate = projectstartdate;
		this.projectenddate = projectenddate;
		this.teamid = teamid;
	}
	public int getProjectid() {
		return projectid;
	}
	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectstartdate() {
		return projectstartdate;
	}
	public void setProjectstartdate(String projectstartdate) {
		this.projectstartdate = projectstartdate;
	}
	public String getProjectenddate() {
		return projectenddate;
	}
	public void setProjectenddate(String projectenddate) {
		this.projectenddate = projectenddate;
	}
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	
}
