package demo111.demo8;

import java.util.Scanner;

class TeacherThread implements Runnable {
    private int teacherIndex;
    private int studentNum;
    private int[] scores;
    private int[] teacherScores;

    public TeacherThread(int teacherIndex, int studentNum, int[] scores, int[] teacherScores) {
        this.teacherIndex = teacherIndex;
        this.studentNum = studentNum;
        this.scores = scores;
        this.teacherScores = teacherScores;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = teacherIndex * studentNum; i < (teacherIndex + 1) * studentNum; i++) {
            sum += scores[i];
        }
        teacherScores[teacherIndex] = sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int teacherNum = scanner.nextInt();

        int studentNum = scanner.nextInt();

        int[] scores = new int[teacherNum * studentNum];

        for (int i = 0; i < teacherNum * studentNum; i++) {
            scores[i] = scanner.nextInt();
        }
        scanner.close();

        int[] teacherScores = new int[teacherNum];

        Thread[] threads = new Thread[teacherNum];
        for (int i = 0; i < teacherNum; i++) {
            threads[i] = new Thread(new TeacherThread(i, studentNum, scores, teacherScores));
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int score : teacherScores) {
            System.out.println(score);
        }
    }
}
