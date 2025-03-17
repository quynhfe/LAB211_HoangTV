/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week7;

/**
 *
 * @author ADMIN
 */
public class Fruit {
//    Fruit Id, Fruit Name, Price, Quantity and Origin.

    private static int count = 0;
    private final int id;
    private String name;
    private double price;
    private int quantity;
    private String origin;

    public Fruit() {
        this.id = ++count;
    }

    public Fruit(String name, double price, int quantity, String origin) {
        this();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Fruit.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public double getTotalBillPrice() {
        return this.quantity * this.price;
    }

    public boolean isDecreaseQuantity(int amount) {
        if (amount <= quantity) {
            this.quantity = quantity - amount;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-20s %-20s %-20s\n", id, name, origin, price);
    }
}
