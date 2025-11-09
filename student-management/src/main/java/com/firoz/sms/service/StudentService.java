package com.firoz.sms.service;

import com.firoz.sms.model.Course;
import com.firoz.sms.model.Student;
import java.util.List;

public interface StudentService {
  Long addStudent(String name, Long courseId);
  void updateStudent(Long id, String name, Long courseId);
  void deleteStudent(Long id);
  Student getStudent(Long id);
  List<Student> listStudents();
  Long addCourse(String name, String duration);
  List<Course> listCourses();
}
