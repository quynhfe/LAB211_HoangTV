/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week3;

/**
 *
 * @author bong
 */
public class BinarySearch extends QuickSort {

    public void search(int x, int low, int high) {
        if (low > high) {
            System.out.println("Couldn't find the value in array...");
            return;
        }
        int middle = low + (high - low) / 2;

        if (array[middle] == x) {
            System.out.println("Found " + x + " at index: " + middle);
        } 
        else if (x < array[middle]) {
             search(x, low, middle - 1);
        } 
        else {
            search(x, middle + 1, high); 
        }
    }
    }
