package com.tw;

import java.util.Scanner;

public class App {

  private static final int ADD_STUDENT = 1;
  private static final int CREATE_GRADELIST = 2;
  private Klass klass;

  App(Klass klass) {
    this.klass = klass;
  }

  private void showSalutatory() {
    System.out.printf("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：%n");
  }

  private void noticeAddStudentMessage() {
    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：");
  }

  private void exitApp() {
    System.out.println("您已退出，谢谢使用！");
  }

  private void inputPrompt() {
    System.out.println("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：");
  }

  private void savePrompt(Student student) {
    System.out.println("学生" + student.getName() + "的成绩被添加");
  }

  private void inputAgain() {
    System.out.println("输入错误，请重新输入！");
  }

  private int getOptionType() {
    int optionType;
    while (true) {
      showSalutatory();
      try {
        Scanner sc = new Scanner(System.in);
        optionType = sc.nextInt();
        break;
      } catch (Exception e) {
        inputAgain();
      }
    }
    return optionType;
  }

  private void saveStudent(Student student) {
    klass.addStudent(student);
    savePrompt(student);
  }

  private String createGradeList() {
    if (klass.getStudents() == null) {
      return "请先添加学生!";
    }
    StringBuilder klassSheet = new StringBuilder(
        "成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n");
    klass.getStudents().forEach(item -> klassSheet.append(item.getGradeSheet()));
    klassSheet.append(String.format("全班总分平均数：%s\n全班总分中位数：%s", klass.getAverage(), klass.getSum()));
    return klassSheet.toString();
  }

//  llr,001,math:100,chinese:100,english:100,program:100
  private Student createStudentByInfo(String studentInfo) {
    String[] stuArr = studentInfo.split(",");
    if (stuArr.length != 6) {
      return null;
    }
    String name = stuArr[0];
    String stuId = stuArr[1];
    String math = stuArr[2].split(":")[1];
    String chinese = stuArr[3].split(":")[1];
    String english = stuArr[4].split(":")[1];
    String program = stuArr[5].split(":")[1];
    return new Student(name, stuId, math, chinese, english, program);
  }

  private void addStudent() {
    Scanner inputSc = new Scanner(System.in);
    String studentInfo = inputSc.nextLine();
    Student newStudent = createStudentByInfo(studentInfo);
    if (newStudent != null) {
      saveStudent(newStudent);
    } else {
      inputPrompt();
      addStudent();
    }
  }

  private void printGradeSheet() {
    System.out.println(createGradeList());
  }

  private void operator(int optionType) {
    switch (optionType) {
      case ADD_STUDENT:
        noticeAddStudentMessage();
        addStudent();
        start();
        break;
      case CREATE_GRADELIST:
        printGradeSheet();
        start();
        break;
      default:
        exitApp();
    }
  }

  public void start() {
    operator(getOptionType());
  }
}
