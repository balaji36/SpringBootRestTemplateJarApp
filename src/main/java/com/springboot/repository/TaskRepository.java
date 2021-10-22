package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.model.Task;

public interface TaskRepository extends CrudRepository<Task,Integer>{

	
}
