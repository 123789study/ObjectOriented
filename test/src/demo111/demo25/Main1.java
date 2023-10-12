package demo111.demo25;

import java.io.Serializable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private String name;
    private int age;
    private String class_name;
    private transient String password;  // 使用transient关键字标记密码属性，表示不会被序列化保存

    public Student(String name, int age, String class_name, String password) {
        this.name = name;
        this.age = age;
        this.class_name = class_name;
        this.password = password;
    }

    // Getter和Setter方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class Main1{
    public static void main(String[] args) {
        // 创建学生对象
        Student student1 = new Student("张三", 18, "高三一班", "123456");
        Student student2 = new Student("李四", 17, "高三二班", "abcdef");

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        // 保存学生对象到文件
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

 class Main2 {
    public static void main(String[] args) {
        // 从文件中读取学生对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            List<Student> students = (List<Student>) ois.readObject();

            // 展示学生信息
            for (Student student : students) {
                System.out.println("姓名: " + student.getName());
                System.out.println("年龄: " + student.getAge());
                System.out.println("班级: " + student.getClass_name());
                System.out.println("密码: ********");  // 密码不展示
                System.out.println();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

