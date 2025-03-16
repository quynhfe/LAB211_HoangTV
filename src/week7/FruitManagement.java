/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

import java.util.ArrayList;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class FruitManagement {

    Validation v = new Validation();
    private ArrayList<Fruit> fList = new ArrayList<>();

    public FruitManagement() {
    }

    public Fruit getFruitById(int id) {
        if (fList.isEmpty()) {
            return null;
        } else {
            for (Fruit f : fList) {
                if (f.getId() == id) {
                    return f;
                }
            }
        }
        return null;
    }

    public void add() {
        String name = v.getValidString("Fruit name");
        double price = v.getValidDoubleLimit("Fruit price", 0, Double.MAX_VALUE);
        int quantity = v.getIntLimit("Fruit quantity", 0, 100000);
        String origin = v.getValidString("Fruit origin");
        fList.add(new Fruit(name, price, quantity, origin));
    }

    public void update() {
        int id;
        do {
            id = v.getValidInt("Enter Fruit id want to ");
        } while (getFruitById(id) != null);
        Fruit f = getFruitById(id);
        String[] menu = new String[]{
            "Update name", "Update price", "Update quantity", "Update origin", "Exit"
        };
        int len = menu.length;
        int choice;
        do {
            choice = v.getChoice(menu, "Information Management");
            switch (choice) {
                case 1: {
                    String name = v.getValidString("Fruit name");
                    f.setName(name);
                    break;
                }
                case 2: {
                    double price = v.getValidDoubleLimit("Fruit price", 0, Double.MAX_VALUE);
                    f.setPrice(price);
                    break;
                }
                case 3: {
                    boolean option = v.getOption("Enter 'I' to increase, enter 'D' to decrease quantity", new String[]{"I", "D"}).equalsIgnoreCase("I");
                    int amount;
                    if (option) {
                        amount = v.getIntLimit("Amount quantity to up", 0, 100000);
                        f.setQuantity(f.getQuantity() + amount);
                    } else {
                        do {
                            amount = v.getIntLimit("Amount quantity to up", 0, 100000);
                        } while (f.isDecreaseQuantity(amount));
                    }
                    break;
                }
                case 4: {
                    f.setOrigin(v.getValidString("Fruit "));
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }

    public void delete() {
        int id;
        Fruit f;
        do {
            id = v.getValidInt("Enter id");
            f = getFruitById(id);
            if (f == null) {
                System.out.println("ID not existed");
            }
        } while (f != null);
        fList.remove(f);
    }

    public void display() {
        if (fList.isEmpty()) {
            System.out.println("Fruit List is emty");
            return;
        } else {
            System.out.println("=========Fruit List========");
            System.out.printf("%-5s %-20s %-20s %-20s %-20s", "ID", "Name", "Price", "Quantity", "Origin");
            for (Fruit t : fList) {
                System.out.println(t.toString());
            }
        }
    }

    public void menu() {
        String[] menu = new String[]{
            "Add", "Update", "Delete", "Display all", "Exit"
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
                    update();
                    break;
                }
                case 3: {
                    delete();
                    break;
                }
                case 4: {
                    display();
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
}
