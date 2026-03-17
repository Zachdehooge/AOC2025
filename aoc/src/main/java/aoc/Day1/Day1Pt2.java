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
            var start = 0;
            var end = 0;

            // Right spin
            if (Objects.equals(x, "R")) {

                start = startingNum;
                startingNum = (startingNum + testing) % range;

                if (startingNum < 0) startingNum += range;
                end = startingNum;

                int timesPassedZero;
                boolean timesPassedZeroDebug = false;
                if (testing > 100){
                    timesPassedZero = testing / 100;
                    foo += timesPassedZero;
                    timesPassedZeroDebug = true;
                }

                System.out.println("R Start: " + start);
                System.out.println("R End: " + end);

                boolean zerocheck = false;
                if (end < start & start != 0) {
                    zerocheck = true;
                    foo+=1;
                }

                if (startingNum == 0 & !zerocheck) {
                    foo = foo + 1;
                }

                System.out.println("Did it pass 0: " + zerocheck);
                System.out.println("Did it timesPassedZero?: " + timesPassedZeroDebug);
                System.out.println();

            // Left spin
            } else if (Objects.equals(x, "L")) {
                start = startingNum;
                startingNum = (startingNum - testing) % range;

                if (startingNum < 0) startingNum += range;
                end = startingNum;

                int timesPassedZero;
                boolean timesPassedZeroDebug = false;
                if (testing > 100){
                    timesPassedZero = testing / 100;
                    foo += timesPassedZero;
                    timesPassedZeroDebug = true;
                }

                System.out.println("L Start: " + start);
                System.out.println("L End: " + end);

                boolean zerocheck = false;
                if (end > start & start != 0) {
                    zerocheck = true;
                    foo+=1;
                }

                if (startingNum == 0 & !zerocheck) {
                    foo = foo + 1;
                }

                System.out.println("Did it pass 0: " + zerocheck);
                System.out.println("Did it timesPassedZero?: " + timesPassedZeroDebug);
                System.out.println();
            }

            //System.out.println(startingNum);

            System.out.println("Foo: " + foo);
            System.out.println();
        }
        return foo;
    }

}

