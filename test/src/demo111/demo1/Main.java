package demo111.demo1;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int total=sc.nextInt();


        for (int i = 0; i < total; i++) {
            int n=sc.nextInt();
            if(n==0){
                Student stu=new Student(sc.nextInt(),sc.next(),sc.nextInt(),sc.next(),sc.nextDouble());
                System.out.println("Student ["+stu+"]");
            }
            if(n==1){
                Teacher tea=new Teacher(sc.nextInt(),sc.next(),sc.nextInt(),sc.next(),sc.nextDouble());
                System.out.println("Teacher ["+tea+"]");
            }
        }
    }
}

abstract class Person {
    private int ID;
    private String name;
    private int birth;

    public Person(int id, String name, int bir) {
        this.ID = id;
        this.name = name;
        this.birth = bir;
    }

    public abstract String getInfo();

    @Override
    public String toString() {
        return "id=" + ID + ", name=" + name + ", bir=" + birth;
    }
}

class Student extends Person {
    private String major;
    private double score;

    public Student(int id, String name, int bir, String major, double score) {
        super(id, name, bir);
        this.major = major;
        this.score = score;
    }

    @Override
    public String getInfo() {
        return "major=" + major + ", score=" + score;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getInfo();
    }
}

class Teacher extends Person {
    private String title;
    private double salary;

    public Teacher(int id, String name, int bir, String title, double salary) {
        super(id, name, bir);
        this.title = title;
        this.salary = salary;
    }

    @Override
    public String getInfo() {
        return "title=" + title + ", salary=" + salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + getInfo();
    }
}

