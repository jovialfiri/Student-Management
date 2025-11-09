package com.firoz.sms.service.impl;

import com.firoz.sms.dao.PaymentDAO;
import com.firoz.sms.dao.StudentDAO;
import com.firoz.sms.model.Payment;
import com.firoz.sms.model.Student;
import com.firoz.sms.service.FeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class FeeServiceImpl implements FeeService {
  private final StudentDAO studentDAO;
  private final PaymentDAO paymentDAO;
  public FeeServiceImpl(StudentDAO studentDAO, PaymentDAO paymentDAO) {
    this.studentDAO = studentDAO;
    this.paymentDAO = paymentDAO;
  }
  @Transactional
  public Payment pay(Long studentId, double amount) {
    if (amount<=0) throw new IllegalArgumentException("amount");
    Student s = studentDAO.findById(studentId);
    if (s==null) throw new IllegalArgumentException("student");
    s.setBalance(s.getBalance()-amount);
    Payment p = new Payment();
    p.setStudent(s);
    p.setAmount(amount);
    p.setDate(LocalDateTime.now());
    paymentDAO.save(p);
    studentDAO.update(s);
    return p;
  }
  @Transactional
  public Payment refund(Long studentId, double amount) {
    if (amount<=0) throw new IllegalArgumentException("amount");
    Student s = studentDAO.findById(studentId);
    if (s==null) throw new IllegalArgumentException("student");
    s.setBalance(s.getBalance()+amount);
    Payment p = new Payment();
    p.setStudent(s);
    p.setAmount(-amount);
    p.setDate(LocalDateTime.now());
    paymentDAO.save(p);
    studentDAO.update(s);
    return p;
  }
}
