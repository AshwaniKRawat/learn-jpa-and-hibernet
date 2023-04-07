package com.ashwani.learnjpaandhibernet.cource.jdbc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {

	@Id
	private long id;
	private String name;
	private String author;
	
	public Course()
	{
		
	}
    
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return "ID = "+id+"  Name= "+name+" Author"+author;
	}
	
}
