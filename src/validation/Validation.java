/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
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

    public String getOutputStringInputMatchRegex(String msg, String regex, String error) {
        String input;
        while (true) {
            System.out.print(msg + ": ");
            input = sc.nextLine().trim();
            if (input.matches(regex)) {
                return input.trim();
            } else {
                System.err.println(error);
            }
        }
    }

    public int getOutputIntInputMatchRegex(String msg, String regex, String error) {
        String input;
        while (true) {
            System.out.print(msg + ": ");
            input = sc.nextLine().trim();
            if (!input.matches(regex)) {
                System.err.println(error);
                continue;
            }
            try {
                int value = Integer.parseInt(input);
                if (value < Integer.MAX_VALUE) {
                    return value;
                } else {
                    System.err.println("Enter number < " + Integer.MAX_VALUE);
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer.");
            }
        }
    }

    public double getOutputDoubleInputMatchRegex(String msg, String regex, String error) {
        String input;
        while (true) {
            System.out.print(msg + ": ");
            input = sc.nextLine().trim();
            if (!input.matches(regex)) {
                System.err.println(error);
                continue;
            }
            try {
                double value = Double.parseDouble(input);
                if (Double.isNaN(value) || Double.isInfinite(value) || value > Double.MAX_VALUE) {
                    throw new NumberFormatException();
                }
                return value;
            } catch (NumberFormatException e) {
                System.err.println(error);
            }
        }
    }

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
        return getIntLimit("Your choice", 1, options.length);
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
    public int getIntLimit(String msg, int a, int b) {
        while (true) {
            int input = getValidInt(msg);
            if (input >= a && input <= b) {
                return input;
            } else {
                System.out.println("Enter integer in range [ " + a + ";" + b + " ]");
            }
        }
    }

    public int getValidPositiveInt(String msg) {
        return getOutputIntInputMatchRegex(msg, "^[1-9]\\d*$", "Please enter an integer > 0.");
    }

    public int getValidInt(String msg) {
        return getOutputIntInputMatchRegex(msg, "-?\\d+", "Please enter an integer.");
    }

    //STRING STRING STRING STRING STRING STRING
    //STRING STRING STRING STRING STRING STRING
    public String getStringFromArray(String arr[], String msg) {
        int i = getChoice(arr, msg);
        return arr[i];
    }

    public boolean isValidString(String str) {
        str = str.trim();
        if (str.isEmpty() || str.equals(" ") || str.equals("\n")) {
            return false;
        }
        return true;
    }

    public String getValidString(String msg) {
        return getOutputStringInputMatchRegex(msg, "^(?=.*[A-Za-z])[A-Za-z ]+$", "Please enter a string.");
    }

    public String getValidStringHaveNumber(String msg) {
        return getOutputStringInputMatchRegex(msg, "^(?=.*[A-Za-z0-9])[A-Za-z0-9 ]+$", "Please enter a valid string.");
    }

    public String getValidStringCanHaveEnter(String msg) {
        return getOutputStringInputMatchRegex(msg, "^(?=.*[A-Za-z])[A-Za-z \n]+$", "Please enter a valid string.");
    }

    public String getValidStringNoMoreThanNCharacter(String msg, int length) {
        while (true) {
            String string = getValidString(msg);
            if (string.length() <= length) {
                return string;
            } else {
                System.err.println("Please enter a string no more than " + length + " characters");
            }
        }
    }

    public String getValidStringHaveNDigit(String msg, int numberDigit, String error) {
        return getOutputStringInputMatchRegex(msg, "^\\d{" + numberDigit + "}$", error);
    }

    public String getValidStringHaveStartStringThenNDigit(String msg, String start, int numberDigit, String error) {
        return getOutputStringInputMatchRegex(msg, "^" + start + "\\d{" + numberDigit + "}$", error);
    }

    public String getValidPhoneNumber() {
        return getOutputStringInputMatchRegex("Phone number", "^0[0-9]{9}(?:[0-9]{2})?$", "Phone number must start with 0 and have 10 or 12 numbers");
    }

    /////////// Check Binary, Decimal, Hex ///////////
    public String getValidBinary(String msg) {
        return getOutputStringInputMatchRegex(msg, "[01]+", "Please enter a Binary number.");
    }

    public String getValidDecimal(String msg) {
        return getOutputStringInputMatchRegex(msg, "\\d+", "Please enter a Decimal number.");

    }

    public String getValidHexadecimal(String msg) {
        return getOutputStringInputMatchRegex(msg, "[0-9A-Fa-f]+", "Please enter a Hexadecimal number.");
    }

    /// DOUBLE DOUBLE DOUBLE DOUBLE DOUBLE DOUBLE//////
    public double getValidDouble(String msg) {
        return getOutputDoubleInputMatchRegex(msg, "^[+-]?\\d+(\\.\\d+)?$", "Please enter a valid real number.");
    }

    public double getValidDoubleGreaterThan(String msg, double numberGreaterThan) {
        while (true) {
            double a = getValidDouble(msg);
            if (a > numberGreaterThan) {
                return a;
            } else {
                System.err.println("Please enter a real number >= " + numberGreaterThan);
            }
        }
    }

    public double getValidDoubleLimit(String msg, double numberGreaterThan, double numberLeftThan) {
        while (true) {
            double a = getValidDouble(msg);
            if (a > numberGreaterThan && a < numberLeftThan) {
                return a;
            } else {
                System.out.println(MAUDO + "Please enter a real number int limit: [ " + numberGreaterThan + " ; " + numberLeftThan + "]");
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
    public boolean isValidSideTriangle(Double a, Double b, Double c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public int getValidNumberHaveNDigit(String msg, int numberDigit, String error) {
        return getOutputIntInputMatchRegex(msg, "^\\d{" + numberDigit + "}$", error);
    }
    /////Date Date Date Date Date Date Date Date Date Date Date 

    public LocalDateTime getValidLocalDateTime(String msg) throws ParseException {
        String input;
        while (true) {
            try {
                System.out.print(msg + " (dd/MM/yyyy HH:mm): ");
                input = sc.nextLine().trim();
                if (!input.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}")) {
                    throw new DateTimeParseException("Invalid format!", input, 0);
                }

                LocalDateTime dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                return dateTime;
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date-time format or incorrect hour/minute (00-23:00-59). Please try again.");
            }
        }
    }

    public Date getValidDate(String msg) throws ParseException {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            if (input.matches("\\d{2}/\\d{2}/\\d{4}")) {
                return new SimpleDateFormat("dd/MM/yyyy").parse(input);
            } else {
                System.err.println("Please enter a date (dd/MM/yyyy):");
            }
        }
    }

    public Date getDateBeforeNow(String msg) throws ParseException {
        while (true) {
            Date date = getValidDate(msg);
            if (date.before(new Date())) {
                return date;
            } else {
                System.err.println("Please enter a date before current day");
            }
        }
    }

    public int getYearBeforeNow(String msg) {
        while (true) {
            int year = getValidInt(msg);
            if (0 < year && year < Calendar.getInstance().get(Calendar.YEAR)) {
                return year;
            } else {
                System.err.println("Please enter a  before  year");
            }
        }
    }

    public int calcutelateAge(int yob) {
        return Calendar.getInstance().get(Calendar.YEAR) - yob;
    }

    public String getOption(String msg, String[] option) {
        String input;
        while (true) {
            System.out.println(msg);
            input = sc.nextLine();
            for (String o : option) {
                if (o.equalsIgnoreCase(input)) {
                    return input;
                }
            }
            System.out.println("Invalid input");
        }
    }
}
