package com.firoz.sms.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "student_id")
  private Long id;

  @Column(nullable = false)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "course_id")
  private Course course;

  @Column(name = "balance", nullable = false)
  private Double balance = 0.0;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public Course getCourse() { return course; }
  public void setCourse(Course course) { this.course = course; }
  public Double getBalance() { return balance; }
  public void setBalance(Double balance) { this.balance = balance; }
}
