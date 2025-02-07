/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

import java.util.ArrayList;

/**
 *
 * @author bong
 */
public class MyStack {

    ArrayList<Integer> stackValue;

    public MyStack() {
        stackValue = new ArrayList<>();
    }

    public void push(int value) {
        stackValue.add(value);
        System.out.println("Add " + value);
    }

    public boolean isEmpty() {
        return stackValue.isEmpty();
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        int value = stackValue.remove(stackValue.size() - 1);
        System.out.println("Pop " + value);
        return value;
    }

    public Integer get() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;
        }
        return stackValue.get(stackValue.size() - 1);
    }
}
