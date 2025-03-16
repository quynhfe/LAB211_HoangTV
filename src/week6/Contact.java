/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week6;

/**
 *
 * @author ADMIN
 */
public class Contact {

    private static int count = 0;
    private final int id;
    private String name;
    private String group;
    private String adress;
    private String phone;

    public Contact() {
        this.id = ++count;
    }

    public Contact(String name, String group, String adress, String phone) {
        this();
        this.name = name;
        this.group = group;
        this.adress = adress;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Contact.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname(String name) {
        String[] spilitName = name.split(" ");
        return spilitName[0];
    }

    @Override
    public String toString() {
        String firstName = getFirstname(name);
        String lastName = name.substring(firstName.length()).trim();
        return String.format("%-5s %-20s %-10s %-20s %-10s %-20s %-15s",
                id, name, firstName, lastName, group, adress, phone);
    }

}
