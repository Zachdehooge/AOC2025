package main.java.aoc.Day1;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Day1Pt2 {

    static void main() {
        ArrayList<String> direction = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("aoc/src/main/java/aoc/Day1/exampleinput.txt"));
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

            int foo = getFoo(direction, number);
            System.out.println("Password = " + foo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getFoo(ArrayList<String> direction, ArrayList<String> number) {
        int i;
        String x;
        int startingNum = 50;

        int range = 100;
        int foo = 0;

        for (i = 0; i < direction.toArray().length; i++) {
            int testing = Integer.parseInt(number.get(i));
            x = direction.get(i);
            if (Objects.equals(x, "R")) {
                startingNum = (startingNum + testing) % range;
            } else {
                startingNum = (startingNum - testing) % range;
            }

            if (startingNum < 0) startingNum += range;

            //System.out.println(startingNum);

            /*
            * If the number passes 0 - then it should be counted

            TODO: Modify the below to determine if it passed 0. If it did, iterate by 1. This is in addition to the already existing functionality
             */

            if (startingNum == 0) {
                foo = foo + 1;
            }
        }
        return foo;
    }

}

