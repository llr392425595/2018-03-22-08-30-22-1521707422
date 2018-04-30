package com.tw.Controller;

import com.tw.Database.Database;
import com.tw.Entity.Klass;
import com.tw.Entity.Student;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

  private Klass db_class = Database.getDatabase().getKlass();
  private static final String HEADER_MESSAGE = "成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n";


  private String createReport(List<Student> students) {
    StringBuilder klassSheet = new StringBuilder(HEADER_MESSAGE);
    students.forEach(item -> klassSheet.append(item.getGradeSheet()));
    klassSheet.append(String.format("全班总分平均数：%s\n全班总分中位数：%s", getAverage(students), getSum(students)));
    return klassSheet.toString();
  }

  private double getSum(List<Student> students) {
    return students.stream().mapToDouble(Student::getSum).sum();
  }

  private double getAverage(List<Student> students) {
    return getSum(students) / students.size();
  }

  public void printReport(List<Student> students) {
    System.out.println(createReport(students));
  }

  public  List<Student> findStudentsByIds(List<String> studentIdsList) {
    return db_class.getStudents().stream().filter(student -> studentIdsList.contains(student.getStuId()))
        .collect(Collectors.toList());
  }

  public void saveStudent(Student student) {
    db_class.addStudent(student);
    System.out.println("学生" + student.getName() + "的成绩被添加");
  }
}
