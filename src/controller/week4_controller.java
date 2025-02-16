/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week4.StudentManagement.StudentManagement;
import week4.StudentTeacher.InformationManagement;

/**
 *
 * @author ADMIN
 */
public class week4_controller {

    StudentManagement studentManagement = new StudentManagement();
    InformationManagement informationManagement = new InformationManagement();
    Validation validation = new Validation();

    public void menu() {
        //alligator2, text to ascii web thu 2
        System.out.println(validation.MAUHONG + " WEEK 4 "+ validation.RESET);

        String[] menu = new String[]{
            "Student Management",
            "Input and display student and teacher information",
            "Return main menu"
        };
        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "WEEK 1");
            switch (choice) {
                case 1: {
                    studentManagement.display();
                    break;
                }
                case 2: {
                    informationManagement.display();
                    break;
                }
                case 5: {
                    System.out.println("Return main menu\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
}
