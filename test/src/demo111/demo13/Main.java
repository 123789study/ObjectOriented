package demo111.demo13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyClock clock1,clock2;

        //输入一个时间：时 分 秒
        Scanner sc = new Scanner(System.in);

        System.out.println("输入一个时间：（时 分 秒用空格分隔）");
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int second = sc.nextInt();

        //用输入的时间初始化时间对象clock1
        clock1 = new MyClock(hour,minute,second);

        //用clock1初始化clock2
        clock2 = new MyClock(clock1);
        //显示两个时间对象
        clock1.display();
        clock2.display();
    }
}

class MyClock {
    //数据成员: 时 分 秒
    private int hour;
    private int minute;
    private int second;
    //方法成员：构造方法1--不带参数的，初始化时钟为 0：0：0
    MyClock(){
        this.hour=0;
        this.minute=0;
        this.second=0;
    }
    //方法成员：构造方法2-- 带参数的，三个参数分别（ 时，分，秒）
    MyClock(int hour,int minute,int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    //方法成员:设置时间
    public void setClock(int hour,int minute,int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //方法成员：构造方法3-- 用对象作为参数
    MyClock(MyClock clock) {
        this.hour=clock.hour;
        this.minute=clock.minute;
        this.second=clock.second;
    }
    //方法成员: 显示时间
    public void display() {
        System.out.format("%2d:%2d:%2d",hour,minute,second);
        System.out.println();
    }
}