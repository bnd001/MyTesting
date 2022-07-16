package com.learn.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTesting {

    class Emp {
        String name;
        Address add;
        public List<Dept> depts;
    }

    class Address {
        public String addr;
    }
    class Dept {
        String id;
    }

    public static void main(String[] args) {
        List<String> sample = new ArrayList<String>();
        sample.add("one");
        sample.add("one1");
        sample.add("one2");
        sample.add("one3");
        String result = "Empty";
        Optional<String> op =  sample.stream().filter(s-> s.equals("one4")).findFirst();
        if (op.isPresent()) {
             result = op.get();
        }

        List<Emp> employees = new ArrayList<>();

        List<Dept> depts = employees.stream().flatMap(e -> e.depts.stream()).collect(Collectors.toList());

        System.out.println(result);


    }
}
