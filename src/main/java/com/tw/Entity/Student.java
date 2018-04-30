package com.tw.Entity;

public class Student {
  private String name;
  private String stuId;
  private double math;
  private double english;
  private double chinese;
  private double program;


  private Student(String name, String stuId, double math, double english, double chinese, double program) {
    this.name = name;
    this.stuId = stuId;
    this.math = math;
    this.english = english;
    this.chinese = chinese;
    this.program = program;
  }

  private Student(String name, String stuId, String math, String chinese, String english, String program) {
    this.name = name;
    this.stuId = stuId;
    this.math = Double.parseDouble(math);
    this.english = Double.parseDouble(chinese);
    this.chinese = Double.parseDouble(english);
    this.program = Double.parseDouble(program);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getProgram() {
    return program;
  }

  public void setProgram(double program) {
    this.program = program;
  }

  public double getChinese() {
    return chinese;
  }

  public void setChinese(double chinese) {
    this.chinese = chinese;
  }

  public double getEnglish() {
    return english;
  }

  public void setEnglish(double english) {
    this.english = english;
  }

  public double getMath() {
    return math;
  }

  public void setMath(double math) {
    this.math = math;
  }

  public String getStuId() {
    return stuId;
  }

  public void setStuId(String stuId) {
    this.stuId = stuId;
  }

  public double getSum(){
    return math+chinese+english+program;
  }

  private double getAverage() {
    return getSum() / 4;
  }

  public String getGradeSheet(){
    return String.format("%s|%s|%s|%s|%s|%s|%s\n", name,math,chinese,english,program,getAverage(),getSum());
  }

  public static Student createStudentByInfo(String studentInfo) {
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


}
