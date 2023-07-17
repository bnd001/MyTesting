package com.java8;





public class MethodRefernce {
    public static void main(String[] args) {
        Sayable obj = SayableClass::saySomethong;
        obj.say();

    }
}



interface Sayable {
    void say();
    int i=0;
}
