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
public class InformationManagement {

    private ArrayList<Teacher> tList = new ArrayList<>();
    private ArrayList<Student> sList = new ArrayList<>();
    private ArrayList<Person> pList = new ArrayList<>();
    Validation v = new Validation();

    public void display() {
        Person p = new Person() {
        };
        String[] menu = new String[]{
            "Teacher",
            "Student",
            "Person",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Information Management");
            switch (choice) {
                case 1: {
                    teacherManagement();
                    break;
                }
                case 2: {
                    studentManagement();
                    break;
                }
                case 3: {
                    personManagement();
                    break;
                }
                case 4: {
                    System.out.println("Exit\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

    public void teacherManagement() {
        Teacher teacher = new Teacher();
        String[] menu = new String[]{
            "Input",
            "Print",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Teacher Management");
            switch (choice) {
                case 1: {
                    teacher.inputAll();
                    tList.add(teacher);
                    pList.add(teacher);
                    break;
                }
                case 2: {
                    System.out.printf("%-10s %-30s %-15s %-20s %-20s %-25s %-15s %-20s\n", "ID", "Full Name", "Phonenumbers", "Year Of Birth", "Major", "Year in the profession", "Contract type", "Salary");
                    for (Teacher t : tList) {
                        t.printAll();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Exit\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

    public void studentManagement() {
        Student student = new Student();
        String[] menu = new String[]{
            "Input",
            "Print",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Student Management");
            switch (choice) {
                case 1: {
                    student.inputAll();
                    sList.add(student);
                    pList.add(student);
                    break;
                }
                case 2: {
                    System.out.printf("%-10s %-30s %-15s %-20s %-20s %-20s %-10s\n", "ID", "Full Name", "Phonenumbers", "Year Of Birth", "Major", "Year of admission", "Entrance English score");
                    for (Student s : sList) {
                        s.printAll();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Exit\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

    public void personManagement() {
        Person person = new Person() {
        };
        String[] menu = new String[]{
            "Search",
            "PrintAll",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Person Management");
            switch (choice) {
                case 1: {
                    String name = v.getValidString("Enter name:");
                    ArrayList<Person> p = search(name);
                    if(p!= null){
                        System.out.printf("%-10s %-30s %-15s %-20s %-20s \n", "ID", "Full Name", "Phonenumbers", "Year Of Birth", "Major"); 
                        for(Person p1: p){
                            p1.printAll();
                        }
                    }
                    else{
                        System.out.println("Not found any person.");
                    }
                    break;
                }
                case 2: {
                    System.out.printf("%-10s %-30s %-15s %-20s %-20s \n", "ID", "Full Name", "Phonenumbers", "Year Of Birth", "Major"); 
                    for (Person p : pList) {
                        p.printAll();
                    }
                    break;
                }
                case 3: {
                    System.out.println("Exit\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

    public ArrayList<Person> search(String name) {
        ArrayList<Person> personFound = new ArrayList<>();
        if (pList.isEmpty()) {
            System.out.println("Not have any person.");
            return null;
        }
        for (Person person : pList) {
            if (person.getName().equalsIgnoreCase(name)) {
                personFound.add(person);
            }
        }
        return personFound;
    }
}
