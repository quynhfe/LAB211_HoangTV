/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author bong
 */
public class Main {
    public static void main(String[] args) {
        try {
           AllWeekController aw = new AllWeekController();
           aw.menu();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
