package com.ashwani.learnjpaandhibernet.cource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ashwani.learnjpaandhibernet.cource.jdbc.Course;
import com.ashwani.learnjpaandhibernet.cource.jdbc.CourseJdbcRepository;
import com.ashwani.learnjpaandhibernet.cource.jpa.CourseJpaRespository;
import com.ashwani.learnjpaandhibernet.cource.springdatajpa.CourseSpringDataJpaRepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{

	
	@Autowired private 
	CourseJdbcRepository jdbcRepository;
	
	@Autowired
	CourseJpaRespository jpaRepository;
	
	@Autowired
	CourseSpringDataJpaRepository springDataJpaRepository;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("######################Using JPA Respsitory#############################");
		//SQL Operation by JPA
		jpaRepository.insert(new Course(1,"Learn AWS Now!-JpaRepository","Ashwani Rawat"));
		jpaRepository.insert(new Course(2,"Learn Spring Boot!-JpaRepository","Ashok IT"));
		jpaRepository.insert(new Course(3,"Learn Kafka!-JpaRepository","Andrian"));
		jpaRepository.insert(new Course(4,"Learn MQ!-JpaRepository","XXXX"));
		System.out.println(jpaRepository.findById(3));
		jpaRepository.deleteById(3);
	
		System.out.println("######################Using JDBC Template#############################");
		//SQL Operation by Spring JDBC Template
		jdbcRepository.insert(new Course(5,"Java 17!-jdbcRepository","Java Author"));
		jdbcRepository.insert(new Course(6,"Spring Cloud!-jdbcRepository","Ashok IT"));
		jdbcRepository.insert(new Course(7,"NAS!-jdbcRepository","YYY"));
		jdbcRepository.insert(new Course(8,"Learn .Net!-jdbcRepository","XXXX"));
		System.out.println(jdbcRepository.getMaxById(1l));
		//SQL Operation by Spring JPA
		//In this approach no need to talk to Entity Manager as I did into above JPA code
		System.out.println("######################Using JPA Respsitory#############################");
		springDataJpaRepository.save(new Course(9,"Learn AWS Now!-springDataJpaRepository","Ashwani Rawat"));
		springDataJpaRepository.save(new Course(10,"Learn Spring Boot!-springDataJpaRepository","Ashok IT"));
		System.out.println(springDataJpaRepository.findAll());
		System.out.println(springDataJpaRepository.findById(7l));
		
		//customized method
		System.out.println("#############Find by Author (Customized method)######################################");
		System.out.println(springDataJpaRepository.findByAuthor("Ashwani Rawat"));
		System.out.println("#############Find by Name (Customized method)######################################");
		System.out.println(springDataJpaRepository.findByName("NAS!-jdbcRepository"));
	}

}
