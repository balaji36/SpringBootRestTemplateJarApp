package com.springboot.controller;


import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.Task;
import com.springboot.service.TaskService;
@Controller
public class SpringControllerApp {
	
	@Autowired
	private TaskService taskService;

	@GetMapping("/demo")
	public String getmessage()
	{
		return "alltask";
	}
	
	@GetMapping("/home")
	public String home(HttpServletRequest request)
	{
		//request.setAttribute("Mode", true);
		request.setAttribute("Title", "HomePage");
		return "index";
	}
	
	@GetMapping("/alltasks")
	public String alltasks(HttpServletRequest request) {
		request.setAttribute("title", "All Tasks");
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("alltask", true);

		return "index";

	}
	
	@GetMapping("/singletask")
	public String singletask(HttpServletRequest request)
	{
		request.setAttribute("title", "One Task");
		request.setAttribute("task", taskService.findTask(5));
		request.setAttribute("singletask", true);
		return "index";

	}
	@GetMapping("/deletetask")
	public String deletetask(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("title", "Delete Task");
		//request.setAttribute("task", 
		request.setAttribute("task", taskService.findTask(id));
		taskService.deleting(id);
		request.setAttribute("message","your id is deleted successfully");
		request.setAttribute("deletetask", true);
		return "index";

	}
	//this is the default insert values method
	@GetMapping("/inserttask")
	public String insert(HttpServletRequest request)
	{
		request.setAttribute("title", "Insert Task");
		taskService.inserting("madhu", "chennai");
		request.setAttribute("tasks", taskService.findAll());
		request.setAttribute("inserttask", true);
		return "index";
	}
	
	@GetMapping("/updatetask")
	public String update(@RequestParam int id,HttpServletRequest request)
	{
		
		request.setAttribute("title", "Update Task");
		taskService.update("balajireddy", "hyd","finish",id);
		request.setAttribute("task", taskService.findTask(id));
		request.setAttribute("updatetask", true);
		
		return "index";
	}
	//inserting values into form
	@PostMapping("/newinsert")
	//@RequestMapping(value = "/newinsert", method = RequestMethod.POST)
	public String inserttask(@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request) {
		request.setAttribute("title", "Insert Task");
		//taskService.inserting(task.getName(), task.getAddrs());
		//request.setAttribute("tasks", taskService.findAll());
		taskService.save(task);
		request.setAttribute("insertmessage", "insert a record successfully");
		request.setAttribute("inserts", true);
		return "index";

	}
	//insert page or form retriving
	@GetMapping("/insert")
	public String insert1(HttpServletRequest request) {
		request.setAttribute("title", "InsertPage Task");
		
		request.setAttribute("insert", true);
		return "index";

	}
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("title", "LoginPage Task");
		
		request.setAttribute("login", true);
		return "index";

	}
	
	@GetMapping("/logintask")
	public String logintask(@RequestParam int id,@RequestParam String name,@RequestParam String addrs,HttpServletRequest request) {
		request.setAttribute("title", "Inbox Task");
		//request.setAttribute("task", 
		//request.setAttribute("task", taskService.findTask(id));
		//taskService.deleting(id);
		Task task=taskService.findTask(id);
		
		if(task.getName().equals(name)&&task.getAddrs().equals(addrs))
		{
		request.setAttribute("message","login successfully");
		request.setAttribute("logintask", true);
		}
		else
		{
			request.setAttribute("message","login Failure");
			request.setAttribute("failuretask", true);
		}
		
		return "index";

	}
	
	/*@GetMapping("/single")
	public String singletask(HttpServletRequest request) {
		request.setAttribute("title", "Single Task");
		
		request.setAttribute("single", true);
		return "index";

	}*/
	
	
	
}
