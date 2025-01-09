/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week1.LetterAndCharacterCount;

/**
 *
 * @author bong
 */
public class LetterAndCharacterCountController {

    LetterAndCharacterCount letterAndCharacterCount = new LetterAndCharacterCount();
    Validation validation = new Validation();

    public void display() {
        System.out.println(validation.MAUXANHLA + "  _         _   _                              _        _                          _                                    _   \n"
                + validation.MAUXANHLA + " | |    ___| |_| |_ ___ _ __    __ _ _ __   __| |   ___| |__   __ _ _ __ __ _  ___| |_ ___ _ __    ___ ___  _   _ _ __ | |_ \n"
                + validation.MAUXANHLA + " | |   / _ \\ __| __/ _ \\ '__|  / _` | '_ \\ / _` |  / __| '_ \\ / _` | '__/ _` |/ __| __/ _ \\ '__|  / __/ _ \\| | | | '_ \\| __|\n"
                + validation.MAUXANHLA + " | |__|  __/ |_| ||  __/ |    | (_| | | | | (_| | | (__| | | | (_| | | | (_| | (__| ||  __/ |    | (_| (_) | |_| | | | | |_ \n"
                + validation.MAUXANHLA + " |_____\\___|\\__|\\__\\___|_|     \\__,_|_| |_|\\__,_|  \\___|_| |_|\\__,_|_|  \\__,_|\\___|\\__\\___|_|     \\___\\___/ \\__,_|_| |_|\\__|\n"
                + "                                                                                                                            "+validation.RESET);
        letterAndCharacterCount.setInput(validation.getValidString("Enter your content: ")) ;
        letterAndCharacterCount.print(letterAndCharacterCount.countLetter());
        letterAndCharacterCount.print(letterAndCharacterCount.countCharacter());
    }
}
