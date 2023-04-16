package com.a.assignment.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assignments{


    public static String reverseSubstringinside(String input) {
        String[] array = input.split("[()]+");
        Arrays.stream(array).forEach(s -> System.out.println(s));
        String resault = "";
        if (array.length < 3) {
            return input;
        } else {
            for (int i=0; i< array.length; i++) {
                if(i%2 == 0) {
                    resault = resault + array[i];
                } else {
                    resault =  resault +"(" + new StringBuffer(array[i]).reverse().toString() + ")";
                }
            }
        }
        return resault;
    }

}