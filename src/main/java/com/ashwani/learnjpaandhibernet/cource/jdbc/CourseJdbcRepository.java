package com.ashwani.learnjpaandhibernet.cource.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private static String INSERT_QUERY = """
					INSERT INTO COURSE (ID,NAME,AUTHOR)
					VALUES(?,?,?);
			""";

	private static String DELETE_QUERY = """
					DELETE FROM COURSE
					WHERE ID=?;
			""";

	private static String GETBY_ID_QUERY = """
					SELECT * FROM COURSE
					WHERE ID=?;
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}

	public void deleteById(long id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	public int getMaxById(long id) {
		return springJdbcTemplate.getMaxRows();
	}

}
