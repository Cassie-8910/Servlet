package com.cassie.model;

public class Student {
    private String stuNum;
    private String name;
    private String gender;
    private String dormNum;
    private String academy;
    private String major;
    private String className;

    public Student(String stuNum, String name, String gender, String dormNum, String academy, String major, String className) {
        this.stuNum = stuNum;
        this.name = name;
        this.gender = gender;
        this.dormNum = dormNum;
        this.academy = academy;
        this.major = major;
        this.className = className;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDormNum() {
        return dormNum;
    }

    public void setDormNum(String dormNum) {
        this.dormNum = dormNum;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dormNum='" + dormNum + '\'' +
                ", academy='" + academy + '\'' +
                ", major='" + major + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
