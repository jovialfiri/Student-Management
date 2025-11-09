package com.firoz.sms.dao.impl;

import com.firoz.sms.dao.StudentDAO;
import com.firoz.sms.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentDAOImpl implements StudentDAO {
  private final SessionFactory sf;
  public StudentDAOImpl(SessionFactory sf) { this.sf = sf; }
  private Session s() { return sf.getCurrentSession(); }
  public Long save(Student st) { return (Long) s().save(st); }
  public void update(Student st) { s().update(st); }
  public void delete(Long id) { Student st = findById(id); if (st!=null) s().delete(st); }
  public Student findById(Long id) { return s().get(Student.class, id); }
  public List<Student> findAll() { return s().createQuery("from Student", Student.class).list(); }
}
