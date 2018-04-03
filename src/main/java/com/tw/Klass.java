package com.tw;

import java.util.ArrayList;
import java.util.List;

public class Klass {
  private List<Student> students = new ArrayList<>();

  public void addStudent(Student student){
    students.add(student);
  }

  public double getSum(){
    double result = 0;
    for (Student student : students) {
      result += student.getSum();
    }
    return result;
  }

  public double getAverage() {
    return getSum() / students.size();
  }

  public List<Student> getStudents() {
    return students;
  }
}
