/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Worker {
//    (id, name,age, salary, work location)

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private ArrayList<SalaryStatus> salaryStatus;

    public Worker() {
        this.id = "";
        this.name = "";
        this.age = 0;
        this.salary = 0.0;
        this.workLocation = "";
        this.salaryStatus = null;
    }

    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public Worker(String id, String name, int age, String workLocation, ArrayList<SalaryStatus> salaryStatus) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.workLocation = workLocation;
        this.salaryStatus = salaryStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<SalaryStatus> getSalaryStatus() {
        return salaryStatus;
    }

    public void setSalaryStatus(ArrayList<SalaryStatus> salaryStatus) {
        this.salaryStatus = salaryStatus;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + age + " - " + salary + " - " + workLocation;
    }

    public String print() {
        return id + " - " + name + " - " + age + " - " + workLocation + " - " + salaryStatus;
    }

}
