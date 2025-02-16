/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4.StudentTeacher;

import java.util.Calendar;

/**
 *
 * @author ADMIN
 */
public class Student extends Person {
//    Year of admission, entrance English score

    private int yoa;
    private double score;

    public Student() {
    }

    public Student(int id, String name, String phone, int yob, String major, int yoa, double score) {
        super(id, name, phone, yob, major);
        this.yoa = 0;
        this.score = 0;
    }

    public int getYoa() {
        return yoa;
    }

    public void setYoa(int yoa) {
        this.yoa = yoa;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.printf("%-20s %-10s\n", yoa, score);
    }

//● Year of admission is between birth year and current year
//● Entrance English score is from 0 to 100.
    @Override
    public void inputAll() {
        super.inputAll();
        this.yoa = v.getIntLimit("Enter Year of admission", v.calcutelateAge(this.getYob()), Calendar.getInstance().get(Calendar.YEAR));
        this.score = v.getValidDoubleLimit("Enter Entrance English score:", 0, 100);
    }

}
