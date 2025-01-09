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
public class Week_1_Controller {

    Validation validation = new Validation();
    LinearSearchController linearSearchController = new LinearSearchController();
    LetterAndCharacterCountController letterAndCharacterCountController = new LetterAndCharacterCountController();
    ChangeBaseNumberSystemProgramController changeBaseNumberSystemProgramController = new ChangeBaseNumberSystemProgramController();
    LastAssignmentWeek1Controller lastAssignmentWeek1Controller = new LastAssignmentWeek1Controller();

    public void menu() {
        //alligator2, text to ascii web thu 2
        System.out.println(validation.MAUHONG + " :::       ::: :::::::::: :::::::::: :::    :::       :::  \n"
                + validation.MAUHONG + ":+:       :+: :+:        :+:        :+:   :+:      :+:+:  \n"
                + validation.MAUHONG + "+:+       +:+ +:+        +:+        +:+  +:+         +:+  \n"
                + validation.MAUHONG + "+#+  +:+  +#+ +#++:++#   +#++:++#   +#++:++          +#+  \n"
                + validation.MAUHONG + "+#+ +#+#+ +#+ +#+        +#+        +#+  +#+         +#+  \n"
                + validation.MAUHONG + " #+#+# #+#+#  #+#        #+#        #+#   #+#        #+#  \n"
                + validation.MAUHONG + "  ###   ###   ########## ########## ###    ###     ####### ");

        String[] menu = new String[]{
            "Letter and character count",
            "Linear search",
            "Change base number system (16, 10, 2) program",
            "Solving the equation, find the square numbers, even numbers, odd numbers",
            "Return main menu"
        };
        int len = menu.length;
        int choice;
        do {
            choice = validation.getChoice(menu, "WEEK 1");
            switch (choice) {
                case 1: {
                    letterAndCharacterCountController.display();
                    break;
                }
                case 2: {
                    linearSearchController.display();
                    break;
                }
                case 3: {
                    changeBaseNumberSystemProgramController.display();
                    break;
                }
                case 4: {
                    lastAssignmentWeek1Controller.display();
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
