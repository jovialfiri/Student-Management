package com.firoz.sms.dao;

import com.firoz.sms.model.Payment;
import java.util.List;

public interface PaymentDAO {
  Long save(Payment p);
  List<Payment> findByStudentId(Long studentId);
}
