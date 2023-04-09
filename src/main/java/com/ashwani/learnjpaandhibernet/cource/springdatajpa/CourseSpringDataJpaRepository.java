package com.ashwani.learnjpaandhibernet.cource.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwani.learnjpaandhibernet.cource.jdbc.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	//some customized method
	List<Course> findByAuthor(String author);

	List<Course> findByName(String course);
	
}
