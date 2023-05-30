package com.learn.stream;

// Java program using flatMap() function
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map_FlatMap {

    class Student {
        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        private int marks;
        private String subject;
    }
    public static void main(String[] args)
    {
        // making the arraylist object of List of Integer
        List<List<Integer> > number = new ArrayList<>();

        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));

        System.out.println("List of list-" + number);

        // using flatmap() to flatten this list
        List<Integer> flatList
                = number.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        flatList
                = number.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        // printing the list
        System.out.println("List generate by flatMap-"
                + flatList);
        System.out.println("****************MAP Reduce*************");
        checkMapReduce();
    }

    private static void checkMapReduce() {
        List<Student> listStudent = new ArrayList<>();

        Stream<Student> streamStudent = listStudent.stream().filter(s->s.getSubject().equals("maths"));

        Stream<Integer> streamMarks = streamStudent.map(s->s.getMarks());
        // using binary operator in reduce
        int sum = streamMarks.reduce(0, (a,b)-> a+b);

    }
}

