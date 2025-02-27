/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week_5;

/**
 *
 * @author ADMIN
 */
public class BigNumberOperations {

    public String add(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = Math.max(len1, len2);
        while (num1.length() < maxLen) {
            num1 = "0" + num1;
        }
        while (num2.length() < maxLen) {
            num2 = "0" + num2;
        }
        int[] array = new int[maxLen + 1];
        int carry = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            int digit2 = num2.charAt(i) - '0';

            int sum = digit1 + digit2 + carry;
            array[i + 1] = sum % 10;
            carry = sum / 10;
        }
        array[0] = carry;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array[i] == 0) {
                continue;
            }
            result.append(array[i]);
        }
        return result.toString();
    }

    public String multi(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        StringBuilder result1 = new StringBuilder();
        int sodu = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int multi = digit1 * digit2 +sodu;
                
                result1.append(multi%10);
                sodu = multi/10;
            }
            String kq;
//            StringBuilder result2 = new StringBuilder();

            
        }

        return "";
    }

    public static void main(String[] args) {
        BigNumberOperations big = new BigNumberOperations();
        System.out.println(big.add("123456789", "1234567789022"));
        System.out.println(big.multi("123", "123"));
    }
}
