package org.example;

import java.util.*;

class Max
{
    public static void main (String[] args) {
        int arr[] = {30, 20, 10};

        // The max() returns an optional int
        // getAsInt() gets the integer from the
        // optional int
        int sum = Arrays.stream(arr)
                .max()
                .getAsInt();

        // Displaying the sum
        System.out.println(sum);
    }
}
