/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week3.BinarySearch;

/**
 *
 * @author bong
 */
public class BinarySearchController {

    BinarySearch binarySearch = new BinarySearch();
    Validation validation = new Validation();

    public void display() {
        System.out.println(validation.MAUXANHBIEN + "Binary Search" + validation.RESET);
        int number = validation.getValidPositiveInt("Enter number of array:");
        int value = validation.getValidInt("Enter search value:");
        binarySearch.addValue(number);
//        binarySearch.printArray("unSorted array");
        binarySearch.quickSort(0, number - 1);
        binarySearch.printArray("Sorted array");
        binarySearch.search(value, 0, number - 1);
    }
}
