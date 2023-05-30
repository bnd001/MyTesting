package com.learn.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StreamFunctions {

    public static void main(String[] args) {
        String[] data = {"Tomcat", "Undertow", "Kubernetes", "JBoss"};
        List<String> servers = new CopyOnWriteArrayList(data);
        // servers = Arrays.asList(data);
        Iterator iterator = servers.iterator();

        while (iterator.hasNext()) {
            Object s = iterator.next();
            System.out.println(s);
            servers.add("Jetty");  // suppresses ConcurrentModificationException
        }
        System.out.println(servers.size());



        for( String s : servers) {
            System.out.println(s);
            servers.remove("Jetty");  // suppresses ConcurrentModificationException
        }
        System.out.println(servers.size());
    }
}
