/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.util.ArrayList;
import java.util.Date;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class WorkerManagerment {

    Validation v = new Validation();
    private ArrayList<Worker> workerList = new ArrayList<>();

    public Worker getWorker(String id) {
        if (workerList.isEmpty()) {
            return null;
        } else {
            for (Worker w : workerList) {
                if (w.getId().equalsIgnoreCase(id)) {
                    return w;
                }
            }
        }
        return null;
    }
//    (id, name,age, salary, work location)

    public void add() {
        String id;
        do {
            id = v.getValidStringHaveStartStringThenNDigit("ID", "DB", 4, "Please enter DBxxxx (id start with DB, xxxx is a number 4 digits)");
        } while (getWorker(id) != null);
        String name = v.getValidString("Name");
        int age = v.getIntLimit("Age", 18, 50);
        double salary = v.getValidDoubleGreaterThan("Salary", 0);
        String workLocation = v.getValidStringHaveNumber("Work Location");
        Worker w = new Worker(id, name, age, salary, workLocation);
        workerList.add(w);
        System.out.println("Add successfull");
        System.out.println(w.toString());
    }

    public void increaseSalary() {
        String id;
        do {
            id = v.getValidStringHaveStartStringThenNDigit("ID", "DB", 4, "Please enter DBxxxx (id start with DB, xxxx is a number 4 digits)");
        } while (getWorker(id) == null);
        Worker w = getWorker(id);
        double amountRaise = v.getValidDoubleGreaterThan("Amount of money to raise", 0);
        w.setSalary(w.getSalary() + amountRaise);
        ArrayList<SalaryStatus> sList = new ArrayList<>();
        SalaryStatus salaryStatus = new SalaryStatus(w.getSalary(), "UP", new Date());
        sList.add(salaryStatus);
        w.setSalaryStatus(sList);
    }

    public void decreaseSalary() {
        String id;
        do {
            id = v.getValidStringHaveStartStringThenNDigit("ID", "DB", 4, "Please enter DBxxxx (id start with DB, xxxx is a number 4 digits)");
        } while (getWorker(id) == null);
        Worker w = getWorker(id);
        double amountDecrease = v.getValidDoubleLimit("Amount of money to cut", 0, w.getSalary());
        w.setSalary(w.getSalary() - amountDecrease);
        ArrayList<SalaryStatus> sList = new ArrayList<>();
        SalaryStatus salaryStatus = new SalaryStatus(w.getSalary(), "DOWN", new Date());
        sList.add(salaryStatus);
        w.setSalaryStatus(sList);
    }

    public void displaySalaryInformation() {
        if (workerList.isEmpty()) {
            System.out.println("No Worker Have Been Adjusted Salary");
        } else {
            for (Worker w : workerList) {
                if (w.getSalaryStatus() != null) {
                    System.out.println(w.print());
                }
            }
        }
    }

    public void printAll() {
        if (workerList.isEmpty()) {
            System.out.println("No workers available.");
        } else {
            System.out.println("======== Worker List ========");
            for (Worker w : workerList) {
                System.out.println(w.toString());
            }
        }
    }

    public void menu() {
        String[] menu = new String[]{
            "Add Worker", "Up salary", "Down salary", "Display Information salary", "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Information Management");
            switch (choice) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    increaseSalary();
                    break;
                }
                case 3: {
                    decreaseSalary();
                    break;
                }
                case 4: {
                    displaySalaryInformation();
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

}
