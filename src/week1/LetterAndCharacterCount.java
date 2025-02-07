/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author bong
 */
public class LetterAndCharacterCount {
    private String input;

    public LetterAndCharacterCount() {
    }

    public LetterAndCharacterCount(String input) {
        this.input = input;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    public Map<String, Integer> countLetter() {
        Map<String, Integer> letterMap = new HashMap<>();
        String[] words = input.split("\\s+"); 
        for (String word : words) {
            letterMap.put(word, letterMap.getOrDefault(word, 0) + 1);
        }
        return letterMap;
    }

     public Map<Character, Integer> countCharacter() {
        Map<Character, Integer> characterMap = new HashMap<>();
        for (char currentChar : input.toCharArray()) {
            if(!Character.isWhitespace(currentChar))
            characterMap.put(currentChar, characterMap.getOrDefault(currentChar, 0) + 1);
        }
        return characterMap;
    }

    public void print(Map<?, Integer> map) {
        System.out.print("{");
        for (Map.Entry<?, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());
            System.out.print(", ");
        }
            System.out.print("\b\b"); 
        System.out.println("}");
    }
}
