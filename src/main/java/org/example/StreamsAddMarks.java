package org.example;


import java.io.*;
import java.util.*;
import java.util.stream.*;

class StreamsAddMarks {

    public static void main(String[] args)
    {

        ArrayList<Integer> marks = new ArrayList<Integer>();

        marks.add(30);
        marks.add(78);
        marks.add(26);
        marks.add(96);
        marks.add(79);

        System.out.println(
                "Marks of students before grace : " + marks);


        // Now we want to add marks by 6
        // using the streams to process over processing

        // Using stream, we map every object and later
        // collect to List
        // and store them
        List<Integer> updatedMarks
                = marks.stream()
                .map(i -> i + 6)
                .collect(Collectors.toList());

        System.out.println(
                "Marks of students after grace : "
                        + updatedMarks);
    }
}
