/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;

/**
 *
 * @author bong
 */
public class Week3_controller {

    Validation validation = new Validation();
    BubbleSortController bubbleSortController = new BubbleSortController();
    QuickSortController quickSortController = new QuickSortController();
    BinarySearchController binarySearchController = new BinarySearchController();
    StackController stackController = new StackController();
    
    public void menu() {
        //alligator2, text to ascii web thu 2
        System.out.println(validation.MAUHONG + ":::       ::: :::::::::: :::::::::: :::    :::      :::::::: \n" +
validation.MAUHONG +":+:       :+: :+:        :+:        :+:   :+:      :+:    :+:\n" +
validation.MAUHONG +"+:+       +:+ +:+        +:+        +:+  +:+              +:+\n" +
validation.MAUHONG +"+#+  +:+  +#+ +#++:++#   +#++:++#   +#++:++            +#++: \n" +
validation.MAUHONG +"+#+ +#+#+ +#+ +#+        +#+        +#+  +#+              +#+\n" +
validation.MAUHONG +" #+#+# #+#+#  #+#        #+#        #+#   #+#      #+#    #+#\n" +
validation.MAUHONG +"  ###   ###   ########## ########## ###    ###      ######## "+ validation.RESET);
        String[] menu = new String[]{
            "Bubble sort algorithm",
            "Quick sort algorithm",
            "Binary search algorithm",
            "Stacks",
            "Return main menu"
        };
        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "WEEK 3");
            switch (choice) {
                case 1: {
                    bubbleSortController.display();
                    break;
                }
                case 2: {
                    quickSortController.display();
                    break;
                }
                case 3: {
                    binarySearchController.display();
                    break;
                }
                case 4: {
                    stackController.display();
                    break;
                }
                case 5: {
                    System.out.println("Return main menu\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);
    }
}
