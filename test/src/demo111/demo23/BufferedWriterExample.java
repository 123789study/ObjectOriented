package demo111.demo23;

import java.io.BufferedWriter;import java.io.FileWriter;import java.io.IOException;import java.io.Writer;import java.util.Random;

public class BufferedWriterExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\电脑小白\\Desktop\\新建文件夹\\random_numbers.txt";
        int numberOfNumbers = 100000;
        try (Writer writer = new FileWriter(filePath); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            Random random = new Random();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < numberOfNumbers; i++) {
                int randomNumber = random.nextInt(100000);
                bufferedWriter.write(Integer.toString(randomNumber));
                bufferedWriter.newLine();
            }
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
            System.out.println("Execution time using BufferedWriter: " + executionTime + " milliseconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
