package com.springboot.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.springboot.model.Task;
import com.springboot.repository.TaskRepository;
@Service
@Transactional
public class TaskService {	
	private final TaskRepository taskRepository;
	public TaskService(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;}
	public List<Task> findAll()
	{
		List<Task> tasks=new ArrayList<>();
		for(Task task:taskRepository.findAll())
		{
			tasks.add(task);}	
		return tasks;
		
	}
	public Task findTask(int id) 
	{
		return taskRepository.findOne(id);
		
	}
	public void inserting(String name, String addrs)
	{
		Task task = new Task(name, addrs, "false");
		taskRepository.save(task);
		
	}
	public void deleting(int id)
	{
		taskRepository.delete(id);
		
	}
	public void update(String name, String addrs,String finished,int id) {
		Task task = new Task();
		Date d=new Date();
	task.setId(id);
	task.setName(name);
	task.setAddrs(addrs);
	task.setFinished(finished);
	//task.setDate(d);
		taskRepository.save(task);}
	public Task save(Task task)
	{
		 return taskRepository.save(task);
	}
	
	

}
