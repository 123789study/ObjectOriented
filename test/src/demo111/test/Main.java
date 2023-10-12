package demo111.test;

import java.util.Objects;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        switch (type) {
            case 1:
                test1(sc);
                break;
            case 2:
                test2(sc);
                break;
            case 3:
                test3(sc);
                break;
            case 4:
                test4(sc);
                break;
        }
    }

    public static void test1(Scanner sc) {
        Student student1 = new Student();
        student1.setStuID(sc.next());
        student1.setStuName(sc.next());

        Student student2 = new Student();
        student2.setStuID(sc.next());
        student2.setStuName(sc.next());
        System.out.println("学生总数为: " + Student.getStuNum());
    }

    public static void test2(Scanner sc) {
        Course course1 = new Course();
        Course course2 = new Course();
        Course course3 = new Course();
        System.out.println("课程总数为: " + Course.getCNum());
    }

    public static void test3(Scanner sc) {
        Student student = new Student(sc.next(), sc.next());

        Course course1 = new Course();
        course1.setCID(sc.next());
        course1.setCName(sc.next());

        Course course2 = new Course();
        course2.setCID(sc.next());
        course2.setCName(sc.next());

        Schedule schedule = new Schedule();
        schedule.addCourse(student, course1);
        schedule.addCourse(student, course2);
        System.out.println("学生选课的总数为: " + Schedule.getSchNum());
        System.out.println("学生选课情况如下: ");
        schedule.displayCourse();
    }

    public static void test4(Scanner sc) {
        Student student1 = new Student(sc.next(), sc.next());
        Student student2 = new Student(sc.next(), sc.next());
        Student student3 = new Student(sc.next(), sc.next());
        Course course1 = new Course(sc.next(), sc.next());
        Course course2 = new Course(sc.next(), sc.next());
        Course course3 = new Course(sc.next(), sc.next());
        Course course4 = new Course(sc.next(), sc.next());
        Schedule schedule = new Schedule();
        schedule.addCourse(student1, course2);
        schedule.addCourse(student1, course3);
        schedule.addCourse(student2, course1);
        schedule.addCourse(student3, course1);
        schedule.addCourse(student3, course2);
        schedule.addCourse(student3, course4);

        System.out.println("学生总数为: " + Student.getStuNum());
        System.out.println("课程总数为: " + Course.getCNum());
        System.out.println("学生选课的总数为: " + Schedule.getSchNum());

        System.out.println("学生选课情况如下: ");
        schedule.displayCourse();
    }
}

class Student {
    private String stuID;
    private String stuName;
    private static int stuNum;

    public Student() {
        System.out.println("学生类无参构造方法");
        stuNum++;
    }

    public Student(String stuID, String stuName) {
        System.out.println("学生类有参构造方法");
        this.stuID = stuID;
        this.stuName = stuName;
        stuNum++;
    }

    public String getStuID() {
        return stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public static int getStuNum() {
        return stuNum;
    }
}

class Course {
    private String cID;
    private String cName;
    private static int cNum;

    public Course() {
        System.out.println("课程类无参构造方法");
        cNum++;
    }

    public Course(String cID, String cName) {
        System.out.println("课程类有参构造方法");
        this.cID = cID;
        this.cName = cName;
        cNum++;
    }

    public String getCID() {
        return cID;
    }

    public String getCName() {
        return cName;
    }

    public void setCID(String cID) {
        this.cID = cID;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public static int getCNum() {
        return cNum;
    }
}

class Schedule {
    private ArrayList<Student> stuList;
    private ArrayList<Course> cList;
    private static int schNum;

    public Schedule() {
        stuList = new ArrayList<Student>();
        cList = new ArrayList<Course>();
    }

    public void addCourse(Student stu, Course course) {
        stuList.add(stu);
        cList.add(course);
        schNum++;
    }

    public void displayCourse() {
        for (int i = 0; i < stuList.size(); i++) {
            System.out.println(stuList.get(i).getStuID() + "\t" + stuList.get(i).getStuName() + "\t" + cList.get(i).getCID() + "\t" + cList.get(i).getCName());
        }
    }

    public static int getSchNum() {
        return schNum;
    }
}

class CodeWordChecker extends StringChecker {

    private int minLen = 6;
    private int maxLen = 20;
    private String symbol;

    public CodeWordChecker(String symbol) {
        this.symbol = symbol;
    }

    public CodeWordChecker() {

    }

    public CodeWordChecker(int minLen, int maxLen, String symbol) {

        this.minLen = minLen;
        this.maxLen = maxLen;
        this.symbol = symbol;
    }

    /**
     * 获取
     *
     * @return minLen
     */
    public int getMinLen() {
        return minLen;
    }

    /**
     * 设置
     *
     * @param minLen
     */
    public void setMinLen(int minLen) {
        this.minLen = minLen;
    }

    /**
     * 获取
     *
     * @return maxLen
     */
    public int getMaxLen() {
        return maxLen;
    }

    /**
     * 设置
     *
     * @param maxLen
     */
    public void setMaxLen(int maxLen) {
        this.maxLen = maxLen;
    }

    /**
     * 获取
     *
     * @return symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * 设置
     *
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void isValid(String str) {
        if (str.contains(this.symbol) || str.length() < minLen || str.length() > maxLen) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    public String toString() {
        return "demo111.demo111.test.CodeWordChecker{minLen = " + minLen + ", maxLen = " + maxLen + ", symbol = " + symbol + "}";
    }
}

class StringChecker {
    private String symbol;

    public StringChecker() {
    }

    public StringChecker(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

class Teacher {
    private Integer no;
    private String name;
    private Integer age;
    private String seminary;

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSeminary() {
        return seminary;
    }

    public void setSeminary(String seminary) {
        this.seminary = seminary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(no, teacher.no) && Objects.equals(name, teacher.name) && Objects.equals(age, teacher.age) && Objects.equals(seminary, teacher.seminary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name, age, seminary);
    }

    public Teacher(Integer no, String name, Integer age, String seminary) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.seminary = seminary;
    }

    public Teacher() {
    }

    public String toString() {
        return "no: " + no + ", name: " + name + ", age: " + age + ", seminary: " + seminary;
    }
}

class Goods {
    private String name;
    private Double price;

    public Goods() {
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置
     *
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public String toString() {
        return name + "," + price;
    }
}

class Book {
    private String name;
    private int number;
    private double price;
    private static int totalBooks = 0;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
        this.number = ++totalBooks;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public static int getTotalBooks() {
        return totalBooks;
    }
}

class People {
    private String name;
    private int age;
    private String education;
    private String position;

    public People() {
    }

    public People(String name, int age, String education, String position) {
        this.name = name;
        this.age = age;
        this.education = education;
        this.position = position;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void introduction() {
        System.out.println("大家好！我是" + name + "，我今年" + age + "岁，"
                + education + "学历，" + "目前职位是" + position);
    }
}

class ComplexNumber {
    private double real;   // 复数的实部
    private double imaginary;   // 复数的虚部

    // 构造方法
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // 获取实部
    public double getReal() {
        return real;
    }

    // 获取虚部
    public double getImaginary() {
        return imaginary;
    }

    // 加法运算
    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    // 减法运算
    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    // 输出复数的字符串表示
    @Override
    public String toString() {
        if (real == 0 && imaginary == 0) {
            return "0";
        } else if (real == 0) {
            return imaginary + "i";
        } else if (imaginary == 0) {
            return String.valueOf(real);
        } else if (imaginary < 0) {
            return real + "" + imaginary + "i";
        } else {
            return real + "+" + imaginary + "i";
        }
    }
}

class Vehicle {
    private String kind;
    private Double speed;
    private String color;

    public Vehicle() {
    }

    public Vehicle(String kind, Double speed, String color) {
        this.kind = kind;
        this.speed = speed;
        this.color = color;
    }

    /**
     * 获取
     *
     * @return kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * 设置
     *
     * @param kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * 获取
     *
     * @return speed
     */
    public Double getSpeed() {
        return speed;
    }

    /**
     * 设置
     *
     * @param speed
     */
    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    /**
     * 获取
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "demo111.demo111.test.Vehicle{kind = " + kind + ", speed = " + speed + ", color = " + color + "}";
    }
}

/*class Student{
    private String name;
    private Double score;

    public Student() {
    }

    public Student(String name, Double score) {
        this.name = name;
        this.score = score;
    }

    *//**
 * 获取
 *
 * @return name
 * <p>
 * 设置
 * @param name
 * <p>
 * 获取
 * @return score
 * <p>
 * 设置
 * @param score
 * <p>
 * 设置
 * @param name
 * <p>
 * 获取
 * @return score
 * <p>
 * 设置
 * @param score
 *//*
    public String getName() {
        return name;
    }

    *//**
 * 设置
 * @param name
 *//*
    public void setName(String name) {
        this.name = name;
    }

    *//**
 * 获取
 * @return score
 *//*
    public Double getScore() {
        return score;
    }

    *//**
 * 设置
 * @param score
 *//*
    public void setScore(Double score) {
        this.score = score;
    }

    public String toString() {
        return "name="+name+",score="+score;
    }
}*/


