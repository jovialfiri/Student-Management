package com.firoz.sms.service.impl;

import com.firoz.sms.dao.CourseDAO;
import com.firoz.sms.dao.StudentDAO;
import com.firoz.sms.model.Course;
import com.firoz.sms.model.Student;
import com.firoz.sms.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  private final StudentDAO studentDAO;
  private final CourseDAO courseDAO;
  public StudentServiceImpl(StudentDAO studentDAO, CourseDAO courseDAO) {
    this.studentDAO = studentDAO;
    this.courseDAO = courseDAO;
  }
  @Transactional
  public Long addStudent(String name, Long courseId) {
    Course c = courseDAO.findById(courseId);
    Student s = new Student();
    s.setName(name);
    s.setCourse(c);
    s.setBalance(0.0);
    return studentDAO.save(s);
  }
  @Transactional
  public void updateStudent(Long id, String name, Long courseId) {
    Student s = studentDAO.findById(id);
    if (s==null) return;
    if (name!=null) s.setName(name);
    if (courseId!=null) s.setCourse(courseDAO.findById(courseId));
    studentDAO.update(s);
  }
  @Transactional
  public void deleteStudent(Long id) { studentDAO.delete(id); }
  @Transactional(readOnly = true)
  public Student getStudent(Long id) { return studentDAO.findById(id); }
  @Transactional(readOnly = true)
  public List<Student> listStudents() { return studentDAO.findAll(); }
  @Transactional
  public Long addCourse(String name, String duration) {
    Course c = new Course();
    c.setName(name);
    c.setDuration(duration);
    return courseDAO.save(c);
  }
  @Transactional(readOnly = true)
  public List<Course> listCourses() { return courseDAO.findAll(); }
}
