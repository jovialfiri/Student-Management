package com.firoz.sms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "payment_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "student_id", nullable = false)
  private Student student;

  @Column(nullable = false)
  private Double amount;

  @Column(nullable = false)
  private LocalDateTime date;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Student getStudent() { return student; }
  public void setStudent(Student student) { this.student = student; }
  public Double getAmount() { return amount; }
  public void setAmount(Double amount) { this.amount = amount; }
  public LocalDateTime getDate() { return date; }
  public void setDate(LocalDateTime date) { this.date = date; }
}
