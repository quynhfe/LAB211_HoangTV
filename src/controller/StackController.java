/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week3.MyStack;

/**
 *
 * @author bong
 */
public class StackController {

    Validation validation = new Validation();
    MyStack myStack = new MyStack();

    public void display() {
        System.out.println(validation.MAUXANHBIEN + "Binary Search" + validation.RESET);

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        System.out.println("Top value: " + myStack.get());

        myStack.pop();
        myStack.pop();

        myStack.pop();
        myStack.pop();
    }
}
