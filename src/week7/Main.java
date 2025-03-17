/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class Main {
    Validation v =new Validation();
    Order o = new Order();
    
    public void menu() {
        String[] menu = new String[]{
            "Create Fruit", "View orders", "Shopping (for buyer)", "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "FRUIT SHOP SYSTEM");
            switch (choice) {
                case 1: {
                    o.addFruit();
                    break;
                }
                case 2: {
                    o.viewOrder();
                    break;
                }
                case 3: {
                    o.createOrder();
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
    
    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }
}
