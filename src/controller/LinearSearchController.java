/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week1.LinearSearch;

/**
 *
 * @author bong
 */
public class LinearSearchController {

    LinearSearch linearSearch = new LinearSearch();
    Validation validation = new Validation();

    public void display() {
        //ivrit
        System.out.println(validation.MAUXANHBIEN + "  _     _                                                 _     \n"
                + validation.MAUXANHBIEN + " | |   (_)_ __   ___  __ _ _ __   ___  ___  __ _ _ __ ___| |__  \n"
                + validation.MAUXANHBIEN + " | |   | | '_ \\ / _ \\/ _` | '__| / __|/ _ \\/ _` | '__/ __| '_ \\ \n"
                + validation.MAUXANHBIEN + " | |___| | | | |  __/ (_| | |    \\__ \\  __/ (_| | | | (__| | | |\n"
                + validation.MAUXANHBIEN + " |_____|_|_| |_|\\___|\\__,_|_|    |___/\\___|\\__,_|_|  \\___|_| |_|\n"
                + "                                                                "+ validation.RESET);
//        System.out.println(validation.MAUXANHLA + "LINEAR SEARCH" + validation.RESET);
        int number = validation.getValidPositiveInt("Enter number of array:");
        int value = validation.getValidInt("Enter search value:");
        linearSearch.addValue(number);
        linearSearch.printArray();
        linearSearch.search(value);

    }
}
