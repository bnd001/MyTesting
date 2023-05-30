package com.learn.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class PrintThreadSequentiallyMain {

    public static void main(String[] args) {

        PrintSequenceRunnable runnable1=new PrintSequenceRunnable(1);
        PrintSequenceRunnable runnable2=new PrintSequenceRunnable(2);
        PrintSequenceRunnable runnable3=new PrintSequenceRunnable(0);


        /*ExecutorService executorService = Executors.newSingleThreadExecutor();
        Thread t = null;
        String name = "";
        List<Thread> listOfThread = new ArrayList<>();
        for (int i=0; i<4;i++) {
            name = "T" + String.valueOf((int) i+1);
            //t = new Thread(new PrintSequenceRunnable(i), name);
            PrintSequenceRunnable runnable2=new PrintSequenceRunnable(i);
            listOfThread.add(t);
            executorService.submit(runnable2);
        }

        executorService.shutdownNow();*/



        Thread t1=new Thread(runnable1,"T1");
        Thread t2=new Thread(runnable2,"T2");
        Thread t3=new Thread(runnable3,"T3");


        t1.start();
        t2.start();
        t3.start();

    }
}
