/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week3.QuickSort;

/**
 *
 * @author bong
 */
public class QuickSortController {

    QuickSort quickSort = new QuickSort();
    Validation validation = new Validation();

    public void display() {
        System.out.println(validation.MAUXANHBIEN + "QUICK SORT" + validation.RESET);
        int number = validation.getValidPositiveInt("Enter number of array:");
        quickSort.addValue(number);
        quickSort.printArray("Unsorted array");
        quickSort.quickSort(0, number - 1);
        quickSort.printArray("Sorted array");
    }
}
