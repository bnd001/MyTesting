package com.learn.stream;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class StreamFunctions {

    public static void main(String[] args) {
        String[] data = {"Tomcat", "Undertow", "Kubernetes", "JBoss"};
        List<String> servers = new CopyOnWriteArrayList(data);
        Iterator iterator = servers.iterator();

        while (iterator.hasNext()) {
            //String s = iterator.next();
            //System.out.println(s);
            servers.add("Jetty");  // suppresses ConcurrentModificationException
        }
    }
}
