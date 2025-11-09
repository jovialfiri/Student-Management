package com.firoz.sms.dao.impl;

import com.firoz.sms.dao.PaymentDAO;
import com.firoz.sms.model.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PaymentDAOImpl implements PaymentDAO {
  private final SessionFactory sf;
  public PaymentDAOImpl(SessionFactory sf) { this.sf = sf; }
  private Session s() { return sf.getCurrentSession(); }
  public Long save(Payment p) { return (Long) s().save(p); }
  public List<Payment> findByStudentId(Long studentId) {
    return s().createQuery("from Payment p where p.student.id=:id order by p.date desc", Payment.class)
      .setParameter("id", studentId).list();
  }
}
