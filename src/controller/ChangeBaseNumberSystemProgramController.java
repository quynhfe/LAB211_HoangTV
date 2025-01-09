/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week1.ChangeBaseNumberSystemProgram;

/**
 *
 * @author bong
 */
public class ChangeBaseNumberSystemProgramController {

    Validation validation = new Validation();
    ChangeBaseNumberSystemProgram changeBaseNumberSystemProgram = new ChangeBaseNumberSystemProgram();

    public void display() {
        System.out.println(validation.MAUDO + "   ____ _                              _                                            _                               _                    ___  __      _  ___     ______                                              \n"
                + validation.MAUDO + "  / ___| |__   __ _ _ __   __ _  ___  | |__   __ _ ___  ___   _ __  _   _ _ __ ___ | |__   ___ _ __   ___ _   _ ___| |_ ___ _ __ ___    / / |/ /_    / |/ _ \\   |___ \\ \\   _ __  _ __ ___   __ _ _ __ __ _ _ __ ___  \n"
                + validation.MAUDO + " | |   | '_ \\ / _` | '_ \\ / _` |/ _ \\ | '_ \\ / _` / __|/ _ \\ | '_ \\| | | | '_ ` _ \\| '_ \\ / _ \\ '__| / __| | | / __| __/ _ \\ '_ ` _ \\  | || | '_ \\   | | | | |    __) | | | '_ \\| '__/ _ \\ / _` | '__/ _` | '_ ` _ \\ \n"
                + validation.MAUDO + " | |___| | | | (_| | | | | (_| |  __/ | |_) | (_| \\__ \\  __/ | | | | |_| | | | | | | |_) |  __/ |    \\__ \\ |_| \\__ \\ ||  __/ | | | | | | || | (_) |  | | |_| |   / __/| | | |_) | | | (_) | (_| | | | (_| | | | | | |\n"
                + validation.MAUDO + "  \\____|_| |_|\\__,_|_| |_|\\__, |\\___| |_.__/ \\__,_|___/\\___| |_| |_|\\__,_|_| |_| |_|_.__/ \\___|_|    |___/\\__, |___/\\__\\___|_| |_| |_| | ||_|\\___( ) |_|\\___( ) |_____| | | .__/|_|  \\___/ \\__, |_|  \\__,_|_| |_| |_|\n"
                + validation.MAUDO + "                          |___/                                                                           |___/                         \\_\\      |/         |/       /_/  |_|              |___/                     " + validation.RESET);
        String[] menu = new String[]{
            "Binary (2)",
            "Decimal (10)",
            "Hexadecimal (16)",
            "Return main menu"
        };

        int len = menu.length;
        int inputBase;
        do {
            inputBase = validation.getChoice(menu, "Choose the INPUT base system");
            switch (inputBase) {
                case 1: {
                    changeBaseNumberSystemProgram.setInput(validation.getValidBinary("Enter a binary number: "));
                    chooseOuputBaseSystem(inputBase);
                    break;
                }
                case 2: {
                    changeBaseNumberSystemProgram.setInput(validation.getValidDecimal("Enter a decimal number: "));
                    chooseOuputBaseSystem(inputBase);
                    break;
                }
                case 3: {
                    changeBaseNumberSystemProgram.setInput(validation.getValidHexadecimal("Enter a hexadecimal number: "));
                    chooseOuputBaseSystem(inputBase);
                    break;
                }
                case 4: {
                    System.out.println("Return main menu\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (inputBase > 0 && inputBase < len);
    }

    public void chooseOuputBaseSystem(int inputBase) {
        String[] menu = new String[]{
            "Binary (2)",
            "Decimal (10)",
            "Hexadecimal (16)",
            "Exit"
        };

        int len = menu.length;
        int outputBase;
        do {
            outputBase = validation.getChoice(menu, "Choose the OUTPUT base system");
            switch (outputBase) {
                case 1:
                    System.out.println(validation.MAUTIMTHAN + "Converted value: " + validation.RESET + changeBaseNumberSystemProgram.convertInputToDecimal(inputBase, 1));
                    break;
                case 2:
                    System.out.println(validation.MAUTIMTHAN + "Converted value: " + validation.RESET + changeBaseNumberSystemProgram.convertInputToDecimal(inputBase, 2));
                    break;
                case 3:
                    System.out.println(validation.MAUTIMTHAN + "Converted value: " + validation.RESET + changeBaseNumberSystemProgram.convertInputToDecimal(inputBase, 3));
                    break;
                case 4: {
                    System.out.println("Exiting...");
                    break;
                }
                default:
                    break;
            }
        } while (outputBase > 0 && outputBase < len);
    }
}
