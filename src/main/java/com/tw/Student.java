package com.tw;

public class Student {
  private String name;
  private String stuId;
  private double math;
  private double english;
  private double chinese;
  private double program;


  public Student(String name, String stuId, double math, double english, double chinese, double program) {
    this.name = name;
    this.stuId = stuId;
    this.math = math;
    this.english = english;
    this.chinese = chinese;
    this.program = program;
  }

  Student(String name, String stuId, String math, String chinese, String english, String program) {
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
}
