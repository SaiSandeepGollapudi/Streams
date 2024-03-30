package org.example;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class StreamsEvenNum {

    public static void main(String[] args)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();


        al.add(2);
        al.add(6);
        al.add(9);
        al.add(4);
        al.add(20);

        System.out.println("Printing the collection : "
                + al);



        // Stream operations
        // 1. Getting the stream from this collection
        // 2. Filtering out only even elements
        // 3. Collecting the required elements to List
        List<Integer> ls
                = al.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        // Print the collection after stream operation
        // as stored in List object
        System.out.println(
                "Printing the even elements after stream operation : "
                        + ls);
    }
}
