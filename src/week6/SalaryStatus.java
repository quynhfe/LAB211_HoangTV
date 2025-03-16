/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class SalaryStatus {

    private double salary;
    private String status;
    private Date date;

    public SalaryStatus() {
    }

    public SalaryStatus(double salary, String status, Date date) {
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return salary + " - " + status + " - " + new SimpleDateFormat("dd/MM/yyyy").format(date);
    }

}
