package demo111.demo11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyClock clock1=new MyClock();
        MyClock clock2=new MyClock();

        //输入一个时间：时 分 秒
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int second = sc.nextInt();
        System.out.println("输入一个时间：（时 分 秒用空格分隔）");

        clock1.setClock(hour,minute,second);

        clock1.display();
        clock2.display();

    }
}


class MyClock {

    private int hour;
    private int minute;
    private int second;

    //方法成员:设置时间
    public void setClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //方法成员: 显示时间
    public void display() {
        System.out.format("%2d:%2d:%2d",hour,minute,second);
        System.out.println();
    }
}


