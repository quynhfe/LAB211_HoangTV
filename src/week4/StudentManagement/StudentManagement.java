/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week4.StudentManagement;

import java.util.ArrayList;
import java.util.Comparator;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class StudentManagement {

    ArrayList<Student> sList = new ArrayList();
    Validation v = new Validation();

    private Student getStudentById(int studentId) {
        for (Student s : sList) {
            if (s.getId() == studentId) {
                return s;
            }
        }
        return null;
    }

    private boolean isStudentHasSameCourseInASemester(int studentId, String semester, String courseName) {
        for (Student s : sList) {
            if (s.getId() == studentId
                    && s.getCourseName().equalsIgnoreCase(courseName)
                    && s.getSemester().equalsIgnoreCase(semester)) {
                return true;
            }
        }
        return false;
    }

    private void showOfAStudent(int studentId) {
        System.out.println("----- Course List -----");
        System.out.printf("%-10s %-30s %-15s %-10s\n", "ID", "Student Name", "Course Name", "Semester");
        System.out.println("-----------------------------------------------------------");

        for (Student s : sList) {
            if (s.getId() == studentId) {
                System.out.printf("%-10s %-30s %-15s %-10s\n", s.getId(), s.getName(), s.getCourseName(), s.getSemester());
            }
        }
    }

    public void add() {
        int id = v.getValidPositiveInt("Enter Student ID:");
        Student student = getStudentById(id);
        String semester, courseName;
        if (student != null) {
            System.out.println("Student ID already exists.");
            showOfAStudent(id);
            semester = v.getValidString("Enter Semester:");
            do {
                courseName = v.getValidString("Enter Course Name:");
            } while (isStudentHasSameCourseInASemester(id, semester, courseName));
            sList.add(new Student(id, student.getName(), semester, courseName));
        } else {
            String name = v.getValidString("Enter Student Name:");
            semester = v.getValidString("Enter Semester:");
            courseName = v.getValidString("Enter Course name:");
            sList.add(new Student(id, name, semester, courseName));
        }
    }

    public void show() {
        if (sList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }
        System.out.println("----- Student List -----");
        System.out.printf("%-10s %-30s %-15s %-10s\n", "ID", "Student Name", "Course Name", "Semester");
        System.out.println("-----------------------------------------------------------");

        for (Student s : sList) {
            System.out.printf("%-10s %-30s %-15s %-10s\n", s.getId(), s.getName(), s.getCourseName(), s.getSemester());
        }
    }

    public void show(ArrayList<Student> list) {
        if (sList.isEmpty()) {
            System.out.println("Student list is empty.");
            return;
        }
        System.out.println(v.MAUDO + "Student List" + v.RESET);
        System.out.printf("%-10s %-30s %-15s %-10s\n", "ID", "Student Name", "Course Name", "Semester");
        System.out.println("-----------------------------------------------------------");

        for (Student s : list) {
            System.out.printf("%-10s %-30s %-15s %-10s\n", s.getId(), s.getName(), s.getCourseName(), s.getSemester());
        }
    }

    public void findAndSortStudents() {
        String searchQuery = v.getValidString("Enter student name (or part of it): ");
        ArrayList<Student> foundSt = new ArrayList<>();
        for (Student student : sList) {
            if (student.name.toLowerCase().contains(searchQuery)) {
                foundSt.add(student);
            }
        }
        if (foundSt.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        foundSt.sort(Comparator.comparing(s -> s.name));
        show(foundSt);
    }

    public void updateOrDeleteStudent() {
        int id = v.getValidPositiveInt("Enter student id:");
        Student s = getStudentById(id);
        if (s == null) {
            System.out.println("Student is not found");
            return;
        }
        String[] menu = new String[]{
            "Update student",
            "Delete",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Do you want to Update (1) or Delete (2) this student?");
            switch (choice) {
                case 1: {
                    updateStudent(s);
                    break;
                }
                case 2: {
                    sList.remove(s);
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

    public void updateStudent(Student student) {
        String[] menu = new String[]{
            "Update student name",
            "Update semester",
            "Update course",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Update student");
            switch (choice) {
                case 1: {
                    updateStName(student);
                    break;
                }
                case 2: {
                    updateSemester(student);
                    break;
                }
                case 3: {
                    updateCourseName(student);
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

    public void updateStName(Student s) {
        s.setName(v.getValidString("Enter new student name:"));
    }

    public void updateSemester(Student s) {
        String semester, courseName;
        showOfAStudent(s.getId());
        courseName = v.getValidString("Enter Course Name:");
        do {
            semester = v.getValidString("Enter Course Name:");
        } while (isStudentHasSameCourseInASemester(s.getId(), semester, courseName));
    }

    public void updateCourseName(Student s) {
        String semester, courseName;
        showOfAStudent(s.getId());
        semester = v.getValidString("Enter Semester:");
        do {
            courseName = v.getValidString("Enter Course Name:");
        } while (isStudentHasSameCourseInASemester(s.getId(), semester, courseName));
    }

    public void display() {
        String[] menu = new String[]{
            "Create",
            "Find and Sort",
            "Report",
            "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Student Management");
            switch (choice) {
                case 1: {
                    add();
                    break;
                }
                case 2: {
                    findAndSortStudents();
                    break;
                }
                case 3: {
                    show();
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
}
