package demo111.demo17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student stu1 = new Student();
        stu1.setName(scanner.next());
        stu1.setScore(scanner.nextDouble());

        Student stu2 = new Student(scanner.next(), scanner.nextDouble());

        System.out.println("stu1:name=" + stu1.getName() + ",score=" + stu1.getScore());
        System.out.println("stu1:name=" + stu2.getName() + ",score=" + stu2.getScore());
    }
}
class Student{
    private String name;
    private double score;

    public Student() {
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
