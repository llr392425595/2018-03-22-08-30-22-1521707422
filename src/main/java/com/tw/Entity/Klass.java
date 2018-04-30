package com.tw.Entity;

import java.util.ArrayList;
import java.util.List;

public class Klass {
  private List<Student> students = new ArrayList<>();

  public void addStudent(Student student){
    students.add(student);
  }

  public double getSum(){
    return students.stream().mapToDouble(Student::getSum).sum();
  }

  public double getAverage() {
    return getSum() / students.size();
  }

  public List<Student> getStudents() {
    return students;
  }
}
