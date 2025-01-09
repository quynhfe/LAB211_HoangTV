/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package week1;

import java.util.Random;

/**
 *
 * @author bong
 */
public class LinearSearch {

    private int[] array;

    public LinearSearch() {
    }

    public LinearSearch(int n) {
        this.array = new int[n];
    }
    
    public void addValue(int number) {
         if (number > 0) {
            array = new int[number];
            for (int i = 0; i < number; i++) {
                array[i] =new Random().nextInt(number);
            }
        }
    }

    public void printArray() {
        System.out.print("The array: [");
        for (int a: array) {
            System.out.print(a);
            System.out.print(" ,");
        }
        System.out.print("\b\b");
        System.out.println("]");
    }

    public void search(int x) {
        int k = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i] == x) {
                System.out.println("Found " + x + " at index: " + i);
                k++;
            }
        }
        if (k == 0) {
            System.out.println("Coudn't find the value in array...\n");
        }
    }

}
