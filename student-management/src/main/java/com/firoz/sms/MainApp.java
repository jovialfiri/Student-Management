package com.firoz.sms;

import com.firoz.sms.config.AppConfig;
import com.firoz.sms.model.Course;
import com.firoz.sms.model.Student;
import com.firoz.sms.service.FeeService;
import com.firoz.sms.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Scanner;

public class MainApp {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    StudentService studentService = ctx.getBean(StudentService.class);
    FeeService feeService = ctx.getBean(FeeService.class);
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("1 Add Course\n2 List Courses\n3 Add Student\n4 Update Student\n5 Delete Student\n6 List Students\n7 Pay Fee\n8 Refund Fee\n9 Exit");
      String ch = sc.nextLine().trim();
      try {
        if ("1".equals(ch)) {
          System.out.print("Course Name: ");
          String n = sc.nextLine();
          System.out.print("Duration: ");
          String d = sc.nextLine();
          Long id = studentService.addCourse(n,d);
          System.out.println("Course ID: "+id);
        } else if ("2".equals(ch)) {
          List<Course> cs = studentService.listCourses();
          cs.forEach(c-> System.out.println(c.getId()+" "+c.getName()+" "+c.getDuration()));
        } else if ("3".equals(ch)) {
          System.out.print("Student Name: ");
          String n = sc.nextLine();
          System.out.print("Course ID: ");
          Long cid = Long.parseLong(sc.nextLine());
          Long sid = studentService.addStudent(n,cid);
          System.out.println("Student ID: "+sid);
        } else if ("4".equals(ch)) {
          System.out.print("Student ID: ");
          Long id = Long.parseLong(sc.nextLine());
          System.out.print("New Name (blank to skip): ");
          String n = sc.nextLine();
          System.out.print("New Course ID (blank to skip): ");
          String cidTxt = sc.nextLine();
          String name = n.isBlank()? null: n;
          Long cid = cidTxt.isBlank()? null: Long.parseLong(cidTxt);
          studentService.updateStudent(id,name,cid);
          System.out.println("Updated");
        } else if ("5".equals(ch)) {
          System.out.print("Student ID: ");
          Long id = Long.parseLong(sc.nextLine());
          studentService.deleteStudent(id);
          System.out.println("Deleted");
        } else if ("6".equals(ch)) {
          List<Student> list = studentService.listStudents();
          list.forEach(s-> System.out.println(s.getId()+" "+s.getName()+" "+(s.getCourse()==null?"-":s.getCourse().getName())+" bal="+s.getBalance()));
        } else if ("7".equals(ch)) {
          System.out.print("Student ID: ");
          Long id = Long.parseLong(sc.nextLine());
          System.out.print("Amount: ");
          double amt = Double.parseDouble(sc.nextLine());
          feeService.pay(id, amt);
          System.out.println("Paid");
        } else if ("8".equals(ch)) {
          System.out.print("Student ID: ");
          Long id = Long.parseLong(sc.nextLine());
          System.out.print("Amount: ");
          double amt = Double.parseDouble(sc.nextLine());
          feeService.refund(id, amt);
          System.out.println("Refunded");
        } else if ("9".equals(ch)) {
          break;
        }
      } catch (Exception e) {
        System.out.println("Error: "+e.getMessage());
      }
    }
    ctx.close();
  }
}
