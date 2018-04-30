package com.tw.View;

import java.io.PrintStream;

public class MessageController {

  private PrintStream sout =System.out;

  public void showMainMenue() {
    sout.print(MessageConstants.MAIN_MENU_MSG);
  }

  public void addStudentInfoMessage() {
    sout.println(MessageConstants.ADD_STUDENT_INFO_MSG);
  }

  public void addStudentInfoErrorMessage() {
    sout.println(MessageConstants.ADD_STUDENT_ERROR_MSG);
  }

  public void printReportMessage() {
    sout.println(MessageConstants.PRINT_REPORT_MSG);
  }

  public void printReportErrorMessage() {
    sout.println(MessageConstants.PRINT_REPORT_ERROR_MSG);
  }

  public void exitMessage() {
    sout.println(MessageConstants.EXIT_MSG);
  }

  public void reinputMessage() {
    sout.println(MessageConstants.REINPUT_MSG);
  }

}
