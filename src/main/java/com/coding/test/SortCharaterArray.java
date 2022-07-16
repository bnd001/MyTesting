package com.coding.test;

public class SortCharaterArray {

    public static void main(String[] args) {
        char[] char_array =  new char[]{'b','a','c','z','j', 'f'};
        char tmp;

        for (int i = 0; i< char_array.length; i++) {
            for(int j=i+1; j < char_array.length; j++) {
                if(char_array[i] > char_array[j]) {
                    tmp = char_array[i];
                    char_array[i] = char_array[j];
                    char_array[j] = tmp;
                }
            }
        }
        System.out.println(char_array);

    }
}
