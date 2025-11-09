package com.firoz.sms.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "course_id")
  private Long id;

  @Column(name = "course_name", nullable = false, unique = true)
  private String name;

  @Column(name = "duration")
  private String duration;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDuration() { return duration; }
  public void setDuration(String duration) { this.duration = duration; }
}
