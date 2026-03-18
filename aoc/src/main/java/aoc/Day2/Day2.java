package main.java.aoc.Day2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
    static void main() {
        try {
            Scanner input = new Scanner("aoc/src/main/java/aoc/Day2/input.txt");
            ArrayList<String> number = new ArrayList<>();
            File file = new File(input.nextLine());
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] foo = line.split("[-,]");
                number.addAll(Arrays.asList(foo));
            }
            input.close();
            //System.out.println(number.get(2));
            for (String foo : number){
                System.out.println(foo);
                /*
                    Need to search for numbers that repeat - 11, 22, 33, 44, 55, 66, 77
                */
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
