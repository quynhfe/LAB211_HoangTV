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
public class Week2_controller {

    Validation validation = new Validation();
    ComputerProgramController computerProgramController = new ComputerProgramController();

    public void menu() {
        //alligator2, text to ascii web thu 2
        System.out.println(validation.MAUHONG + ":::       ::: :::::::::: :::::::::: :::    :::      :::::::: \n"
                + validation.MAUHONG + ":+:       :+: :+:        :+:        :+:   :+:      :+:    :+:\n"
                + validation.MAUHONG + "+:+       +:+ +:+        +:+        +:+  +:+             +:+ \n"
                + validation.MAUHONG + "+#+  +:+  +#+ +#++:++#   +#++:++#   +#++:++            +#+   \n"
                + validation.MAUHONG + "+#+ +#+#+ +#+ +#+        +#+        +#+  +#+         +#+     \n"
                + validation.MAUHONG + " #+#+# #+#+#  #+#        #+#        #+#   #+#       #+#      \n"
                + validation.MAUHONG + "  ###   ###   ########## ########## ###    ###     ##########" + validation.RESET);

        String[] menu = new String[]{
            "Develop a computer program.",
            //            "Linear search",
            //            "Change base number system (16, 10, 2) program",
            //            "Solving the equation, find the square numbers, even numbers, odd numbers",
            "Return main menu"
        };
        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "WEEK 1");
            switch (choice) {
                case 1: {
                    computerProgramController.display();
                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
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
