package demo111.demo9;

import java.util.Scanner;

public class Main {
    public static boolean isValidIdentifier(String str) {
        // 使用正则表达式匹配合法标识符
        String pattern = "^[_$\\p{L}\\p{M}][0-9_$\\p{L}\\p{M}]*$";
        return str.matches(pattern);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            boolean isValid = isValidIdentifier(line);
            System.out.println(isValid);
        }
    }
}

