/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

import java.util.Random;

/**
 *
 * @author bong
 */
public abstract class Sort {
    int[] array;

    public Sort() {
    }

    public Sort(int[] array) {
        this.array = array;
    }
    
    public void addValue(int number) {
        if (number > 0) {
            array = new int[number];
            for (int i = 0; i < number; i++) {
                array[i] = new Random().nextInt(number);
            }
        }
    }

    public void printArray(String msg) {
        System.out.print(msg+": [");
        for (int a : array) {
            System.out.print(a);
            System.out.print(" ,");
        }
        System.out.print("\b\b");
        System.out.println("]");
    }
}
