/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

/**
 *
 * @author bong
 */
public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle() {
    }

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2; 
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public void printResult() {
        System.out.println("----Triangle----");
        System.out.println("Side A: " + a);
        System.out.println("Side B: " + b);
        System.out.println("Side C: " + c);
        super.printResult();
    }

}
