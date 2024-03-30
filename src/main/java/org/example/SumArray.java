package org.example;

import java.util.Arrays;

public class SumArray {
    public static void main(String[] args) {
        int arr[] = {30,20,10};

        //Arrays.stream(arr): This converts the array arr into a stream of elements.
        // Arrays.stream() is a static method in the Arrays class
        //Sum is a terminal method which sums all the elements
        int sum=  Arrays.stream(arr).sum();

        System.out.println(sum);

    }

}
