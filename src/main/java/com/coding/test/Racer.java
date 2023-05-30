package com.coding.test;

public class Racer implements Runnable {

    private static Object lock;
    public static void main(String[] args) {
        Thread t1 = new Thread(new Racer("1"));
        Thread t2 = new Thread(new Racer("2"));
        Thread t3 = new Thread(new Racer("3"));
        Thread t4 = new Thread(new Racer("4"));
        Thread t5 = new Thread(new Racer("5"));

        t5.start();
        t3.start();
        t1.start();
        t3.start();

    }

    private String name;

    public Racer(String name) {

        this.name = name;
    }
    @Override
    public void run() {
        try{
            if(this.name == "3") {
                Thread.sleep(1000);
                System.out.println(name);
            }

        }catch (InterruptedException e){

        }
    }
}
