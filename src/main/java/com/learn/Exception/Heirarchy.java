package com.learn.Exception;

public class Heirarchy {

    public static void main(String[] args) {
        Heirarchy h = new Heirarchy();
        h.createObject();
    }

    void createObject() {
    D d = new D();
    A a = (A)d;
    B b = (B)a;


    }

    class A {

    }

    class B extends A {

    }

    class C extends A {

    }
    class D extends B {

    }
}
