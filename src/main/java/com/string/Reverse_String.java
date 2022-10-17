package com.string;

public class Reverse_String {
    public static void main(String[] args) {
        String str = "This is a Sentence";
        reverseSentence(str);
        System.out.println("\n");
        // Reverse Letter
        reverseLetters(str);
    }

    private static String reverseLetters(String str) {
        char[] charArr = str.toCharArray();
        String result = "";
        int len = charArr.length;
        for(int i = len-1; i>=0; i--) {
            result += charArr[i];
        }
        System.out.println(result);
        return result;
    }

    // Reverse sentence;
    static String reverseSentence(String str) {
        String result = "";
        String[] words = str.split(" ");
        int len = words.length;
        for(int i = len-1; i>= 0; i--) {
            if(!result.isEmpty()) {
                result += " ";
            }
            result += words[i];
            //System.out.print(words[i] + " ");
        }
        System.out.print(result);
        return result;
    }
}
