package com.firoz.sms.dao.impl;

import com.firoz.sms.dao.CourseDAO;
import com.firoz.sms.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseDAOImpl implements CourseDAO {
  private final SessionFactory sf;
  public CourseDAOImpl(SessionFactory sf) { this.sf = sf; }
  private Session s() { return sf.getCurrentSession(); }
  public Long save(Course c) { return (Long) s().save(c); }
  public Course findById(Long id) { return s().get(Course.class, id); }
  public Course findByName(String name) {
    try {
      Query<Course> q = s().createQuery("from Course c where c.name=:n", Course.class);
      q.setParameter("n", name);
      return q.getSingleResult();
    } catch (NoResultException e) { return null; }
  }
  public List<Course> findAll() { return s().createQuery("from Course", Course.class).list(); }
}
