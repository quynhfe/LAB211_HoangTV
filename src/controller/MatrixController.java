/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import validation.Validation;
import week2.Matrix;

/**
 *
 * @author bong
 */
public class MatrixController {

    Validation validation = new Validation();

    public Matrix inputMatrix(String matrixName) {
        int rows = validation.getValidInt("Enter Row " + matrixName + ": ");
        int columns = validation.getValidInt("Enter Column " + matrixName + ": ");
        Matrix matrix = new Matrix(rows, columns);
        matrix.inputMatrix(matrixName);
        return matrix;
    }

    public void printResult(Matrix a, Matrix b, Matrix result, String op) {
        System.out.println("---------Result--------");
        a.display();
        System.out.println(op);
        b.display();
        System.out.println("=");
        result.display();
    }

    public void display() {
        System.out.println(validation.MAUXANHBIEN + "  _     _                                                 _     \n"
                + validation.MAUXANHBIEN + " | |   (_)_ __   ___  __ _ _ __   ___  ___  __ _ _ __ ___| |__  \n"
                + validation.MAUXANHBIEN + " | |   | | '_ \\ / _ \\/ _` | '__| / __|/ _ \\/ _` | '__/ __| '_ \\ \n"
                + validation.MAUXANHBIEN + " | |___| | | | |  __/ (_| | |    \\__ \\  __/ (_| | | | (__| | | |\n"
                + validation.MAUXANHBIEN + " |_____|_|_| |_|\\___|\\__,_|_|    |___/\\___|\\__,_|_|  \\___|_| |_|\n"
                + "                                                                " + validation.RESET);

        String[] menu = new String[]{
            "Addition matrixes",
            "Subtraction matrixes",
            "Multiplication matrixes",
            "Exit the program"
        };
        int len = menu.length;
        int choice;
        Matrix matrix1;
        Matrix matrix2;
        Matrix result;
        do {
            choice = validation.getChoice(menu, "MENU");
            switch (choice) {
                case 1: {
                    validation.printChoice(menu, choice);
                    matrix1 = inputMatrix("Matrix1");
                    matrix2 = new Matrix(matrix1.getNumRow(), matrix1.getNumColumn());
                    System.out.println(validation.MAUDO + "The default of Matrix 2 is as follows so that matrix Addition can be performed:" + validation.RESET);
                    System.out.println("Row Matrix2: " + matrix2.getNumRow());
                    System.out.println("Column Matrix2: " + matrix2.getNumColumn());
                    System.out.println();
                    matrix2.inputMatrix("Matrix2");
                    result = matrix1.add(matrix2);
                    printResult(matrix1, matrix2, result, "+");
                    break;
                }
                case 2: {
                    validation.printChoice(menu, choice);
                    matrix1 = inputMatrix("Matrix1");
                    matrix2 = new Matrix(matrix1.getNumRow(), matrix1.getNumColumn());
                    System.out.println(validation.MAUDO + "The default of Matrix 2 is as follows so that matrix Subtraction can be performed:" + validation.RESET);
                    System.out.println("Row Matrix2: " + matrix2.getNumRow());
                    System.out.println("Column Matrix2: " + matrix2.getNumColumn());
                    System.out.println();
                    matrix2.inputMatrix("Matrix2");
                    result = matrix1.subtract(matrix2);
                    printResult(matrix1, matrix2, result, "-");
                    break;
                }
                case 3: {
                    validation.printChoice(menu, choice);
                    matrix1 = inputMatrix("Matrix1");
                    matrix2 = inputMatrix("Matrix2");
                    result = matrix1.multiply(matrix2);
                    printResult(matrix1, matrix2, result, "*");
                    break;
                }
                case 4: {
                    System.out.println("Exit the program\n");
                    break;
                }
                default: {
                    break;
                }
            }

        } while (choice > 0 && choice < len);

    }
}
