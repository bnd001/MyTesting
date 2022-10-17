package com.coding.test.optum;

import java.util.*;

public class DartGame {

    public static void main(String[] args) {
        // I/P: ["D10", "T2", "18", "17", "D19", "SB"]


        String[] str = {"20", "D20", "T20", "T20", "T20", "T20", "5", "6", "3"};

        //   40+60+60+60+60=280

        // 301-280 ?21

        List<String> inputList = Arrays.asList(str);


        int result = calculateScore(inputList);

        System.out.println("Score: " + result);
    }

    private static int calculateScore(List<String> inputList) {
        boolean isStartCount = false;
        boolean isBusted = false;
        int startScore = 0;
        int tmp = 301;
        int index = 0;
        int roundIndex = 0;
        int len = inputList.size()/3;

        int[] roundScore = new int[len];


        for(String round : inputList)
        {
            index ++;
            if (!isStartCount && round.startsWith("D")) {
                isStartCount = true;
            }
            if (isStartCount) {
                if(round.startsWith("D"))
                {
                    tmp = tmp - 2 * Integer.parseInt(round.substring(1));
//                    if (index % 3 == 0) {
//                        startScore = tmp;
//                    }

                } else if(round.startsWith("T")) {

                    tmp = tmp - 3 * Integer.parseInt(round.substring(1));

                    if (tmp <= 1) {
                        isBusted = true;
                    }

                } else {
                    if (round.equals("SB"))
                    {
                        tmp = startScore - 25;
                    } else {
                        tmp = tmp - Integer.parseInt(round);
                    }
                    if (tmp <= 1) {
                        isBusted = true;
                    }
                }
                if (index % 3 == 0 && !isBusted) {
                    roundScore[roundIndex] = startScore;
                    roundIndex ++;
                    startScore = tmp;
                }
            }
        }
        return startScore;
    }
}
