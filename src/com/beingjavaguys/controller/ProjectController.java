package com.beingjavaguys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.Project;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.services.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@RequestMapping("/home")
	public ModelAndView homePage() {
		
		return new ModelAndView("projectIndex");
	}

	@RequestMapping(value = "/getPojectFromDB", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE, headers="Accept=*/*")
	public  @ResponseBody List<Project> getPojectFromDB(HttpServletRequest request){
	
		System.out.println("Text from TextBox Data is:"+request.getParameter("usern"));
		/*
		List<Project> arr = projectService.getProjectList(request.getParameter("usern"));
		System.out.println("Ans Project List size is:"+arr.size());
		
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(arr, new TypeToken<List<Project>>() {}.getType());

		JsonArray jsonArray = element.getAsJsonArray();*/
		List<Project> arr = projectService.getProjectList(request.getParameter("usern"));
		System.out.println("Ans Project List size is:"+arr.size());
		
		return arr;
	}

	@RequestMapping(value = "/getUserServlet", method = RequestMethod.GET)
	public ModelAndView getProjectName(HttpServletRequest request){
		HttpSession session = request.getSession();
		String projId = request.getParameter("id");
		System.out.println("Project ID is:"+projId);
		
		int projectID = Integer.parseInt(projId);
		Project project = projectService.getProject(projectID);
		System.out.println("Project Name from DB is:"+project.getProjectname());
		String projectName = project.getProjectname();
		session.setAttribute("projectName", projectName);
		
		return new ModelAndView("projectFixedFrame","project", project);
		
	}
	
}
