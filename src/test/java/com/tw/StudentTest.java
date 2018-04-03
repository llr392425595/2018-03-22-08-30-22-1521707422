package com.tw;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
  @Test
  public void getSum() {
    Student mockedStudent = mock(Student.class);
    when(mockedStudent.getSum()).thenReturn(400.0);
    Double expected = 400.0;
    assertEquals(expected, mockedStudent.getSum(),0.01);
  }

  @Test
  public void getGradeSheet() {
    Student mockedStudent = mock(Student.class);
    when(mockedStudent.getGradeSheet()).thenReturn("llr|110.0|100.0|120.3|111.2|110.3|441.5\n");
    String expected = "llr|110.0|100.0|120.3|111.2|110.3|441.5\n";
    assertEquals(expected,mockedStudent.getGradeSheet());
  }
}