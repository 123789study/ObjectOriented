package demo111.demo7;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            CountdownThread countdownThread = new CountdownThread(num);
            Thread thread = new Thread(countdownThread);
            thread.start();
        }
    }

class CountdownThread implements Runnable {
    private int count;

    public CountdownThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        while (count >= 0) {
            System.out.println(count);
            count--;
            try {
                Thread.sleep(500); // 线程休眠500毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
