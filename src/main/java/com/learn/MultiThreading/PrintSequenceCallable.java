package com.learn.MultiThreading;

import java.util.concurrent.Callable;

public class PrintSequenceCallable implements Callable {

    public int PRINT_NUMBERS_UPTO=100;
    static int  number=1;
    int remainder;
    static Object lock=new Object();

    PrintSequenceCallable(int remainder)
    {
        this.remainder=remainder;
    }


    @Override
    public Object call() {
        while (number < PRINT_NUMBERS_UPTO-1) {
            synchronized (lock) {
                while (number % 3 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }

        }
        return null;
    }
}
