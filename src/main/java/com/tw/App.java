package com.tw;

import com.tw.Controller.InputController;
import com.tw.Controller.Service;
import com.tw.Entity.Student;
import com.tw.View.MessageController;
import java.util.Arrays;
import java.util.List;

public class App {

  private static final int ADD_STUDENT_STATUS = 1;
  private static final int PRINT_REPORT_STATUS = 2;
  private static final int EXIT_STATUS = 3;
  private MessageController messageController = new MessageController();
  private InputController inputController = new InputController();
  private Service service = new Service();

  public void start() {
    operator(inputController.getOptionType());
  }

  private void operator(int optionType) {
    if (optionType == ADD_STUDENT_STATUS) {
      addStudentOperator();
    }
    if (optionType == PRINT_REPORT_STATUS) {
      printGradeOperator();
    }
    if (optionType == EXIT_STATUS) {
      messageController.exitMessage();
    }
  }

  private void addStudentOperator() {
    messageController.addStudentInfoMessage();
    addStudent();
    start();
  }

  private void printGradeOperator() {
    messageController.printReportMessage();
    printReport();
    start();
  }

  // 001,002,003...
  private void printReport() {
    String studentIdsInfo = inputController.getStudentIds();
    List<String> studentIdsList = Arrays.asList(studentIdsInfo.split(","));

    List<Student> studentList = service.findStudentsByIds(studentIdsList);
    if (studentList.size() != 0) {
      service.printReport(studentList);
    } else {
      messageController.printReportErrorMessage();
      printReport();
    }
  }

  //  llr,001,math:100,chinese:100,english:100,program:100
  private void addStudent() {
    String studentInfo = inputController.getStudentInfo();
    Student newStudent = Student.createStudentByInfo(studentInfo);
    if (newStudent != null) {
      service.saveStudent(newStudent);
    } else {
      messageController.addStudentInfoErrorMessage();
      addStudent();
    }
  }

}
