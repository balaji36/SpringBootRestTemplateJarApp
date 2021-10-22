package com.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="task")
public class Task implements Serializable{

	
	public Task() {
		super();
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}

	
	private String name;
	private String addrs;
	
	private String finished;
	
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", addrs=" + addrs + ", finished="
				+ finished /* + ", date=" + date */
				+ "]";
	}
	public Task(String name, String addrs, String finished) {
		super();

		this.name = name;
		this.addrs = addrs;
		this.finished = finished;
		
	}
	public Task orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
