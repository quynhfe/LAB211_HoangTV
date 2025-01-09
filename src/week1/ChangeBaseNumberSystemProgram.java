/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

/**
 *
 * @author bong
 */
public class ChangeBaseNumberSystemProgram {
    private String input;

    public ChangeBaseNumberSystemProgram() {
    }

    public ChangeBaseNumberSystemProgram(String input) {
        this.input = input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }
      public String binaryToDecimal() {
        int decimalValue = 0;
        for (int i = 0; i < input.length(); i++) {
            char bit = input.charAt(input.length() - 1 - i);
            if (bit == '1') {
                decimalValue += Math.pow(2, i);
            }
        }
        return String.valueOf(decimalValue);
    }
    
    public String hexadecimalToDecimal() {
        int decimalValue = 0;
        for (int i = 0; i < input.length(); i++) {
            char hexChar = input.charAt(input.length() - 1 - i);
            int digitValue;
            if (hexChar >= '0' && hexChar <= '9') {
                digitValue = hexChar - '0';
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                digitValue = hexChar - 'A' + 10;
            } else {
                return null; 
            }
            decimalValue += digitValue * Math.pow(16, i);
        }
        return String.valueOf(decimalValue);
    }
    
    public String decimalToBinary() {
        int decimalValue = Integer.parseInt(input);
        StringBuilder binaryString = new StringBuilder();
        while (decimalValue > 0) {
            binaryString.insert(0, decimalValue % 2);
            decimalValue /= 2;
        }
        return binaryString.toString();
    }
    
    public String decimalToHexadecimal() {
        int decimalValue = Integer.parseInt(input);
        StringBuilder hexString = new StringBuilder();
        while (decimalValue > 0) {
            int remainder = decimalValue % 16;
            if (remainder < 10) {
                hexString.insert(0, (char) ('0' + remainder));
            } else {
                hexString.insert(0, (char) ('A' + (remainder - 10)));
            }
            decimalValue /= 16;
        }
        return hexString.toString();
    }
    
    public String convertInputToDecimal(int inputBase, int outputBase) {
        try {
            int decimalValue;
            switch (inputBase) {
                case 1:
                    decimalValue = Integer.parseInt(binaryToDecimal());
                    break;
                case 2:
                    decimalValue = Integer.parseInt(input);
                    break;
                default:
                    decimalValue = Integer.parseInt(hexadecimalToDecimal());
                    break;
            }

            switch (outputBase) {
                case 1:
                    return decimalToBinary();
                case 2:
                    return String.valueOf(decimalValue);
                default:
                    return decimalToHexadecimal();
            }
        } catch (NumberFormatException e) {
            return null; 
        }
    }
}
