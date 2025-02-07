/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week3.BubbleSort;

/**
 *
 * @author bong
 */
public class BubbleSortController {

    BubbleSort bubbleSort = new BubbleSort();
    Validation validation = new Validation();

    public void display() {
        System.out.println(validation.MAUXANHBIEN + "  ____        _     _     _        ____             _   \n"
                + validation.MAUXANHBIEN + " | __ ) _   _| |__ | |__ | | ___  / ___|  ___  _ __| |_ \n"
                + validation.MAUXANHBIEN + " |  _ \\| | | | '_ \\| '_ \\| |/ _ \\ \\___ \\ / _ \\| '__| __|\n"
                + validation.MAUXANHBIEN + " | |_) | |_| | |_) | |_) | |  __/  ___) | (_) | |  | |_ \n"
                + validation.MAUXANHBIEN + " |____/ \\__,_|_.__/|_.__/|_|\\___| |____/ \\___/|_|   \\__|\n"
                + validation.MAUXANHBIEN + "                                                        " + validation.RESET);
        int number = validation.getValidPositiveInt("Enter number of array:");
        bubbleSort.addValue(number);
        bubbleSort.printArray("Unsorted array");
        bubbleSort.bubbleSort();
        bubbleSort.printArray("Sorted array");
    }
}
