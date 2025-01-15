/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week2.Circle;
import week2.Rectangle;
import week2.Shape;
import week2.Triangle;

/**
 *
 * @author bong
 */
public class ShapeController {

    Validation validation = new Validation();

    public void display() {
        System.out.println(validation.MAUXANHBIEN + " __     __    _     __    _     _      __   _____  ____      ___   ____  ___   _   _      ____ _____  ____  ___      \n"
                + validation.MAUXANHBIEN + "/ /`   / /\\  | |   / /`  | | | | |    / /\\   | |  | |_      | |_) | |_  | |_) | | | |\\/| | |_   | |  | |_  | |_)     \n"
                + validation.MAUXANHBIEN + "\\_\\_, /_/--\\ |_|__ \\_\\_, \\_\\_/ |_|__ /_/--\\  |_|  |_|__     |_|   |_|__ |_| \\ |_| |_|  | |_|__  |_|  |_|__ |_| \\     \n"
                + validation.MAUXANHBIEN + "  __    _      ___        __    ___   ____   __        ___   ____      __   _      __    ___   ____                  \n"
                + validation.MAUXANHBIEN + " / /\\  | |\\ | | | \\      / /\\  | |_) | |_   / /\\      / / \\ | |_      ( (` | |_|  / /\\  | |_) | |_                   \n"
                + validation.MAUXANHBIEN + "/_/--\\ |_| \\| |_|_/     /_/--\\ |_| \\ |_|__ /_/--\\     \\_\\_/ |_|       _)_) |_| | /_/--\\ |_|   |_|__                  "
                + "                                                                \n" + validation.RESET);
//        System.out.println(validation.MAUXANHLA + "LINEAR SEARCH" + validation.RESET);
        double width = validation.getValidDoubleGreaterThan("Please input side width of Rectangle: ", 0);
        double length = validation.getValidDoubleGreaterThan("Please input length of Rectangle: ", 0);
        Shape rectangle = new Rectangle(width, length);
        double radius = validation.getValidRadius("Please input radius of Circle: ");
        Shape circle = new Circle(radius);
        double a, b, c;

        while (true) {
            a = validation.getValidDoubleGreaterThan("Please input side A of Triangle: ", 0);
            b = validation.getValidDoubleGreaterThan("Please input side B of Triangle: ", 0);
            c = validation.getValidDoubleGreaterThan("Please input side C of Triangle: ", 0);

            if (validation.isValidSideTriangle(a, b, c)) {
                break;
            } else {
                System.err.println("Do not satisfy the sides of a triangle! Please enter again.");
            }
        }
        Shape triangle = new Triangle(a, b, c);
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }
}
