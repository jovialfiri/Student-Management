package com.firoz.sms.dao;

import java.util.List;

import com.firoz.sms.model.Course;

public interface CourseDAO {
  Long save(Course c);
  Course findById(Long id);
  Course findByName(String name);
  List<Course> findAll();
}
