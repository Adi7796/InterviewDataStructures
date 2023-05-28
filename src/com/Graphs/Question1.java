package com.Graphs;

import java.util.Arrays;
import java.util.Comparator;

public class Question1 {
    public static void main(String[] args) {
        Comparator<Integer> comp = (number1, number2)->number2.compareTo(number1);
        Integer arr[] ={1,4,3,2} ;
        Arrays.sort(arr, comp);
        for(Integer numbr : arr){
            System.out.println(numbr);
        }
    }
}
