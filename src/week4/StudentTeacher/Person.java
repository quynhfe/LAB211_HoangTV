/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4.StudentTeacher;

import java.util.ArrayList;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public abstract class Person {
    Validation v = new Validation();
//    ID, full name, phone number, year of birth, major

    protected int id;
    protected String name, phone;
    protected int yob;
    protected String major;

    public Person() {
    }

    public Person(int id, String name, String phone, int yob, String major) {
        this.id = 0;
        this.name = "";
        this.phone = "";
        this.yob = 0;
        this.major = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void printAll() {
//        System.out.printf("%-10s %-30s %-15s %-10s %-20s \n", "ID", "Full Name", "Phonenumbers", "Yer Of Birth", "Major");  
        System.out.printf("%-10s %-30s %-15s %-20s %-20s ", id, name, phone, yob, major);  
    }
//InputAll() method allow user input value of all attributes in format. If data input is invalid,
//the program show error message.
//● ID is a 6 digits
//● Fullname is alphabet and blanks
//● Phone number is 12 digits
//● Year of birth must be before current year
//● Major is a string no more than 30 characters

    public void inputAll() {
        this.id = v.getValidNumberHaveNDigit("Enter id:", 6, "Please enter number 6 digits.");
        this.name = v.getValidString("Enter name:");
        this.phone = v.getValidPhonenumberHaveNDigit("Enter phonenumber:", 12, "Enter Phone number is 12 digits");
        this.yob = v.getYearBeforeNow("Enter year of birth:");
        this.major = v.getValidStringNoMoreThanNCharacter("Enter major:", 30);
    }
}
