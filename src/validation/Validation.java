/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author bong
 */
public class Validation {

    private Scanner sc = new Scanner(System.in);

    private final Pattern INT_PATTERN = Pattern.compile("^\\d+$");
    private final Pattern STRING_PATTERN = Pattern.compile("^.+$");

    //color
    public final String RESET = "\033[0m";
    public final String MAUDO = "\033[31m";
    public final String MAUXANHLA = "\033[32m";
    public final String MAUVANG = "\033[33m";
    public final String MAUXANHBIEN = "\033[34m";
    public final String MAUTIMTHAN = "\033[36m";
    public final String MAUXAM = "\\033[90m";
    public final String MAUHONG = "\033[35m";

    // MENU MENU MENU MENU MENU MENU MENU 
    public void inMang(String[] options, String msg) {
        printStringCenterSpecialWord(msg, "=", 50);
        int len = options.length;
        for (int i = 0; i < len; i++) {
            System.out.println(MAUXANHBIEN + (i + 1) + RESET + ". " + options[i]);
        }
        printAWordWithLength("=", 50);
    }

    public int getChoice(String[] options, String msg) {
        inMang(options, msg);
        return getIntLimit("Your choice: ", 1, options.length);
    }

    public void printChoice(String[] options, int choice) {
        System.out.println("-----" + options[choice - 1] + "-----");
    }

    public void printAWordWithLength(String word, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(word);
        }
        System.out.println("");
    }

    public void printStringCenterSpecialWord(String str, String word, int lengWord) {
        int lengStr = str.trim().length();
        int range = (lengWord - lengStr) / 2;
        System.out.println("\n");
        for (int i = 0; i < range; i++) {
            System.out.print(word);
        }
        System.out.print(MAUDO + str + RESET);
        for (int i = 0; i < range; i++) {
            System.out.print(word);
        }
        System.out.println("");
    }

    //INT INT INT INT INT INT INT INT INT 
    public boolean checkIntLimit(String input, int a, int b) {
        if (!INT_PATTERN.matcher(input).matches()) {
            System.err.println("Input must be a valid integer.");
            return false;
        }
        int num = Integer.parseInt(input);
        if (num >= a && num <= b) {
            System.out.println("");
            return true;
        } else {
            System.err.println("Input must be between " + a + " and " + b + ".");
            return false;
        }
    }

    public int getIntLimit(String msg, int a, int b) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (checkIntLimit(input, a, b)) {
                return Integer.parseInt(input);
            }
        }
    }

    public int getValidPositiveInt(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (input != null && !input.trim().isEmpty() && input.matches("\\d+")) {
                return Integer.parseInt(input);
            } else {
                System.err.println("Please enter an integer.");
            }
        }
    }

    public int getValidInt(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (input != null && !input.trim().isEmpty() && input.matches("^[+-]?\\d+$")) {
                return Integer.parseInt(input);
            } else {
                System.err.println("Please enter an integer.");
            }
        }
    }

    //STRING STRING STRING STRING STRING STRING
    //STRING STRING STRING STRING STRING STRING
    public boolean isValidString(String str) {
        str = str.trim();
        if (str.isEmpty() || str.equals(" ") || str.equals("\n")) {
            return false;
        }
        return true;
    }

    public String getValidString(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (isValidString(input)) {
                return input.trim();
            } else {
                System.err.println("Please enter a string.");
            }
        }
    }

    /////////// Check Binary, Decimal, Hex ///////////
    public String getValidBinary(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.matches("[01]+")) {
                return input.trim();
            } else {
                System.err.println("Please enter a Binary number.");
            }
        }
    }

    public String getValidDecimal(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.matches("\\d+")) {
                return input.trim();
            } else {
                System.err.println("Please enter a Decimal number.");
            }
        }
    }

    public String getValidHexadecimal(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.matches("[0-9A-Fa-f]+")) {
                return input.trim();
            } else {
                System.err.println("Please enter a Hexadecimal number.");
            }
        }
    }

    ////FLOAT FLOAT FLOAT FLOAT FLOAT ////////////
    public boolean isValidFloat(String input) {
        try {
            Float.parseFloat(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public float getValidFloat(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (isValidFloat(input)) {
                return Float.parseFloat(input);
            } else {
                System.out.println(MAUDO + "Please enter a real number.");
            }
        }
    }

    /// DOUBLE DOUBLE DOUBLE DOUBLE DOUBLE DOUBLE//////
    public boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public double getValidDouble(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (isValidDouble(input)) {
                return Double.parseDouble(input);
            } else {
                System.out.println(MAUDO + "Please enter a real number.");
            }
        }
    }

    public double getValidDoubleGreaterThan(String msg, double numberGreaterThan) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (isValidDouble(input) && (Double.parseDouble(input) > numberGreaterThan)) {
                return Double.parseDouble(input);
            } else {
                System.out.println(MAUDO + "Please enter a real number > " + numberGreaterThan);
            }
        }
    }
    //// Even, Odd, Perfect number ////////

    public boolean isEven(double number) {
        return number % 2 == 0;
    }

    public boolean isOdd(double number) {
        return number % 2 != 0;
    }

    public boolean isPerfectSquare(double number) {
        if (number < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        return (sqrt * sqrt) == number;
    }

    /////////Operator//////////
    public boolean isOperator(String input) {
        input = input.trim();
        return input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("^") || input.equals("=");
    }

    public String getValidOperator(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (isOperator(input)) {
                return input.trim();
            } else {
                System.err.println("Please input (+, -, *, /, ^)");
            }
        }
    }

    ///////Shape shape shape shape ///////
    public boolean isValidRadius(String input) {
        return isValidDouble(input) && (Double.parseDouble(input) > 0);
    }

    public double getValidRadius(String msg) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (isValidRadius(input)) {
                return Double.parseDouble(input);
            } else {
                System.err.println("Please input a real number > 0");
            }
        }
    }

    public boolean isValidSideTriangle(Double a, Double b, Double c) {
        return a + b > c && a + c > b && b + c > a;
    }

}
