/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

/**
 *
 * @author bong
 */
public abstract class Shape {
    public abstract double getPerimeter();
    public abstract double getArea();
    public void printResult(){
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Area: " + getArea());
    };
}
