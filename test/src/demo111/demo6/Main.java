package demo111.demo6;

import java.util.HashMap;
import java.util.Scanner;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> countMap = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String line;

        while (true) {
            line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }

            String[] names = line.split("\\s+");
            for (String name : names) {
                name = name.trim();
                countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            }
        }

        List<String> sortedNames = new ArrayList<>(countMap.keySet());
        Collections.sort(sortedNames);

        for (String name : sortedNames) {
            int count = countMap.get(name);
            System.out.println(name + " " + count);
        }
    }
}
