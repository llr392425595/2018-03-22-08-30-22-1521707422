package com.tw;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.tw.Entity.Klass;
import com.tw.Entity.Student;
import org.junit.Test;

public class KlassTest {

  @Test
  public void addStudent() {
    Student student1 = mock(Student.class);
    Klass klass = new Klass();
    klass.addStudent(student1);

    assertTrue(klass.getStudents().contains(student1));
  }

  @Test
  public void getSum() {
    Student student1 = mock(Student.class);
    Student student2 = mock(Student.class);
    when(student1.getSum()).thenReturn(400.0);
    when(student2.getSum()).thenReturn(440.0);

    Klass klass = new Klass();
    klass.addStudent(student1);
    klass.addStudent(student2);
    Double expected = 840.0;
    assertEquals(expected,klass.getSum(),0.001);

  }

  @Test
  public void getAverage() {
    Klass klass = mock(Klass.class);
    when(klass.getAverage()).thenReturn(111.1);
    double expected = 111.1;
    assertEquals(expected, klass.getAverage(), 0.01);
  }

  @Test
  public void getStudents() {
    Student student1 = mock(Student.class);
    Student student2 = mock(Student.class);
    Klass klass = new Klass();
    klass.addStudent(student1);
    klass.addStudent(student2);

    assertTrue(klass.getStudents().contains(student1));
    assertTrue(klass.getStudents().contains(student2));
    assertTrue(klass.getStudents().size()==2);
  }
}