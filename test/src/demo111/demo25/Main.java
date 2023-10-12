package demo111.demo25;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 从键盘输入一系列字母
        System.out.println("请输入一系列字母，以逗号分隔：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 将字母存储到文件中
        try {
            FileWriter writer = new FileWriter("input.txt");
            writer.write(input);
            writer.close();
        } catch (IOException e) {
            System.out.println("写入文件失败：" + e.getMessage());
        }

        // 读取文件内容并按逗号分割成字母数组
        String[] letters = input.split(",");
        // 去除空格
        for (int i = 0; i < letters.length; i++) {
            letters[i] = letters[i].trim();
        }

        // 对字母数组进行升序排序
        Arrays.sort(letters);

        // 将排序后的结果存储到另一个文件中
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (String letter : letters) {
                writer.write(letter + ",");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("写入文件失败：" + e.getMessage());
        }

        // 在屏幕上显示排序后的结果
        System.out.println("排序后的结果：");
        for (String letter : letters) {
            System.out.print(letter + " ");
        }
        System.out.println();
    }

}
