package demo111.demo10;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double avg=(a+b+c)/3.0;

        System.out.println(a+b+c+" "+a*b*c+" "+new DecimalFormat("0.00").format(avg));

    }
}
