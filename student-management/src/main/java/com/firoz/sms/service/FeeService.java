package com.firoz.sms.service;

import com.firoz.sms.model.Payment;

public interface FeeService {
  Payment pay(Long studentId, double amount);
  Payment refund(Long studentId, double amount);
}
