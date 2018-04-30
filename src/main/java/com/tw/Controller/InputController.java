package com.tw.Controller;

import com.tw.View.MessageController;
import java.util.Scanner;

public class InputController {

  private Scanner inputSc = new Scanner(System.in);
  private MessageController messageController = new MessageController();

  public int getOptionType() {
    int optionType;
    while (true) {
      messageController.showMainMenue();
      try {
        optionType = inputSc.nextInt();
        break;
      } catch (Exception e) {
        messageController.reinputMessage();
      }
    }
    return optionType;
  }

  public String getStudentInfo() {
    String studentInfo;
    while (true) {
      try {
        studentInfo = inputSc.next();
        break;
      } catch (Exception e) {
        messageController.reinputMessage();
      }
    }
    return studentInfo;
  }

  public String getStudentIds() {
    String studentIds;
    while (true) {
      try {
        studentIds = inputSc.next();
        break;
      } catch (Exception e) {
        messageController.reinputMessage();
      }
    }
    return studentIds;
  }
}
