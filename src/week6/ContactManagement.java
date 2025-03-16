/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

import java.util.ArrayList;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class ContactManagement {

    Validation v = new Validation();
    private ArrayList<Contact> conList = new ArrayList<>();

    public ContactManagement() {
    }
    
    public boolean isContactExisted(int id){
        if (conList.isEmpty()) {
            System.out.println("Contact List is emty");
            return false;
        } else {
            for (Contact c : conList) {
                if (c.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    } 
    public void add() {
        String fname = v.getValidString("Enter First Name");
        String lname = v.getValidString("Enter Last Name");
        String name = fname + lname;
        String group = v.getValidString("Enter group");
        String address = v.getValidStringHaveNumber("Enter Adress");
        String phone = v.getValidStringNoMoreThanNCharacter("Enter phone", 10);
        Contact c = new Contact(name, group, address, phone);
        conList.add(c);
        System.out.println("Success");
    }

    public void display() {
        if (conList.isEmpty()) {
            System.out.println("Contact List is emty");
            return;
        } else {
            System.out.println("=========Contact List========");
            System.out.printf("%-5s %-20s %-10s %-20s %-10s %-20s %-15s", "ID","Name", "First Name", "Last Name", "Group", "Adress", "Phone");
            for (Contact t : conList) {
                System.out.println(t.toString());
            }
        }
    }

    public void delete(int id) {
        if (conList.isEmpty()) {
            System.out.println("Contact List is emty");
            return;
        } else {
            for (Contact c : conList) {
                if (c.getId() == id) {
                    conList.remove(c);
                }
            }
        }
    }
    
    public void menu() {
        String[] menu = new String[]{
            "Add Contact", "Display All Contact", "Delete Contact", "Exit"
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
                    display();
                    break;
                }
                case 3: {
                    int id;
                    do{
                    id = v.getValidInt("Enter ID you want delete");}
                    while(!isContactExisted(id));
                    delete(id);
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
}
