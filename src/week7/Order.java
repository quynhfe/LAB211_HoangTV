/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

import java.util.ArrayList;
import java.util.HashMap;
import validation.Validation;

/**
 *
 * @author ADMIN
 */
public class Order {

    Validation v = new Validation();
    HashMap<Customer, ArrayList<Fruit>> orderList = new HashMap<>();
    FruitManagement fm = new FruitManagement();

    public void addFruit() {
        fm.add();
    }

    public void displayFruitOrder(ArrayList<Fruit> f) {
        if (f.isEmpty()) {
            System.out.println("Fruit List is emty");
            return;
        } else {
            System.out.println("=========Fruit List========");
            System.out.printf("%-15s %-10s %-10s %-20s", "Product|", "Quantity |", "Price |", "Amount");
            System.out.println("");
            for (Fruit t : f) {
                System.out.printf("%-15s %-10s %-10s %-20s", t.getName(), t.getQuantity(), t.getPrice(), t.getTotalBillPrice());
            }
        }
        System.out.println("Total: " + calculateBill(f));
    }

    public void createOrder() {
        ArrayList<Fruit> fList = new ArrayList<>();
        boolean option = false;
        do {
            if (fm.getfList().isEmpty()) {
                System.out.println("Fruit List is empty. Returning to main menu.");
                return; 
            }
            fm.display(fm.getfList());
            int choice;
            do {
                choice = v.getIntLimit("Choose item number", 1, fm.getfList().size());
            } while (choice < 1 || choice > fm.getfList().size());
            Fruit f = fm.getFruitById(choice);
            System.out.println("You selected: " + f.getName());
            int quantity = v.getIntLimit("Please input quantity", 1, f.getQuantity());
            fm.getFruitById(choice).isDecreaseQuantity(quantity);
            fList.add(new Fruit(f.getName(), f.getPrice(), quantity, f.getOrigin()));
            fm.checkQuantityAndUpdate();
            option = v.getOption("Do you want to order now (Y/N)?", new String[]{"Y", "N"}).equalsIgnoreCase("Y");
        } while (!option);
        displayFruitOrder(fList);
        String name = v.getValidString("Input your name:");
        String phonne = v.getValidPhoneNumber();
        orderList.put(new Customer(name, phonne), fList);
    }

    public double calculateBill(ArrayList<Fruit> f) {
        double total = 0;
        for (Fruit fruit : f) {
            total += fruit.getTotalBillPrice();
        }
        return total;
    }

    public void viewOrder() {
        if (orderList.isEmpty()) {
            System.out.println("No order");
            return;
        }
        for (HashMap.Entry<Customer, ArrayList<Fruit>> entry : orderList.entrySet()) {
            System.out.println(entry.getKey());
            displayFruitOrder(entry.getValue());
            System.out.println("");
        }
    }

}
