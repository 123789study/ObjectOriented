package demo111.demo5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder article = new StringBuilder();
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("!!!!!")) {
                break;
            }
            article.append(line).append(" ");
        }

        int uniqueWordCount = countUniqueWords(article.toString());
        System.out.println(uniqueWordCount);
    }

    public static int countUniqueWords(String article) {
        String[] words = article.toLowerCase().split("\\s+");
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        return uniqueWords.size();
    }
}
