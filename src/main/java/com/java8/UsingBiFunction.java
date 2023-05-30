package com.java8;

import java.util.function.BiFunction;

class Arithmetic{
    public int add(int a, int b){
        return a+b;
    }
}
public class UsingBiFunction {
    public static void main(String[] args) {
        Arithmetic obj = new Arithmetic();
        BiFunction<Integer, Integer, Integer> adder = new Arithmetic()::add;
        int result = adder.apply(10, 20);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> adder2 = obj::add;

        System.out.println(adder2.apply(30,40));
    }
}