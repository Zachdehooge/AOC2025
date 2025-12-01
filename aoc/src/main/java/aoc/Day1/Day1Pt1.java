package main.java.aoc.Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Day1Pt1 {

    static void main() {
        ArrayList<String> direction = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("aoc/src/main/java/aoc/Day1/input.txt"));
            String line = reader.readLine();
            while (line != null) {
                //System.out.println(line);
                char determineDir = line.charAt(0);
                String determineNum = line.substring(1);
                //System.out.println(determineDir);
                direction.add(String.valueOf(determineDir));
                number.add(determineNum);

                line = reader.readLine();
            }
            reader.close();
            //System.out.println(direction);
            //System.out.println("\n" + number);

            int i;
            String x = "";
            int startingNum = 50;

            int range = 100;
            int pos;

            for (i = 0; i < direction.toArray().length; i++){
                int testing = Integer.parseInt(number.get(i));
                x = direction.get(i);
                if (Objects.equals(x, "R")) {
                    startingNum = (startingNum + testing) % range;
                } else {
                    startingNum = (startingNum - testing) % range;
                }

                if (startingNum < 0) startingNum += range;

                System.out.println(startingNum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

