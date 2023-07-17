package com.learn.algo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountCharFrequency {
    public static void main(String[] args) {
        String input = "Hello, Worleed!";
        char highestFrequencyCharacter = findHighestFrequencyCharacter(input);
        System.out.println("Character with the highest frequency: " + highestFrequencyCharacter);
    }

    public static char findHighestFrequencyCharacter(String input) {
        // Create a map to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Traverse the input string and update the frequency map
        for (char c : input.toCharArray()) {
            // Ignore spaces and special characters
            if (Character.isLetter(c)) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }
        }

        // Variables to store the highest frequency and corresponding character
        int maxFrequency = 0;
        char highestFrequencyCharacter = '\0';

        // Iterate over the frequency map to find the highest frequency character
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            char c = entry.getKey();
            int frequency = entry.getValue();

            if (frequency > maxFrequency || (frequency == maxFrequency && c < highestFrequencyCharacter)) {
                maxFrequency = frequency;
                highestFrequencyCharacter = c;
            }
        }

        return highestFrequencyCharacter;
    }
}

