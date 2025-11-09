package com.firoz.sms.dao;

import com.firoz.sms.model.Student;
import java.util.List;

public interface StudentDAO {
  Long save(Student s);
  void update(Student s);
  void delete(Long id);
  Student findById(Long id);
  List<Student> findAll();
}
