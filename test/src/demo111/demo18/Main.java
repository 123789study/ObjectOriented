package demo111.demo18;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Person implements Comparable<Person> {
    String name;
    int age;
    boolean gender;

    public Person(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        if (name != null ? !name.equals(person.name) : person.name != null) {
            return false;
        }
        return age == person.age && gender == person.gender;
    }

    public int compareTo(Person person) {
        int nameComparison = this.name.compareTo(person.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return Integer.compare(this.age, person.age);
    }
}

class Student extends Person {
    String stuNo;
    String clazz;

    public Student(String name, int age, boolean gender, String stuNo, String clazz) {
        super(name, age, gender);
        this.stuNo = stuNo;
        this.clazz = clazz;
    }

    public String toString() {
        return "Student:" + super.toString() + "-" + stuNo + "-" + clazz;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        if (stuNo != null ? !stuNo.equals(student.stuNo) : student.stuNo != null) {
            return false;
        }
        return clazz != null ? clazz.equals(student.clazz) : student.clazz == null;
    }
}

class Company {
    String name;

    public Company(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Company company = (Company) obj;
        return name != null ? name.equals(company.name) : company.name == null;
    }
}

class Employee extends Person {
    Company company;
    double salary;

    public Employee(String name, int age, boolean gender, double salary, Company company) {
        super(name, age, gender);
        this.salary = salary;
        this.company = company;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#.#");
        return "Employee:" + super.toString() + "-" + company + "-" + df.format(salary);
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        if (company != null ? !company.equals(employee.company) : employee.company != null) {
            return false;
        }
        DecimalFormat df = new DecimalFormat("#.#");
        return Double.compare(salary, employee.salary) == 0 || df.format(salary).equals(df.format(employee.salary));
    }
}

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Student> stuList = new ArrayList<>();
        List<Employee> empList = new ArrayList<>();
        while (true) {
            String input = System.console().readLine();
            if (input.equals("s")) {
                String name = System.console().readLine();
                int age = Integer.parseInt(System.console().readLine());
                boolean gender = Boolean.parseBoolean(System.console().readLine());
                String stuNo = System.console().readLine();
                String clazz = System.console().readLine();
                Student student = new Student(name, age, gender, stuNo, clazz);
                personList.add(student);
                stuList.add(student);
            } else if (input.equals("e")) {
                String name = System.console().readLine();
                int age = Integer.parseInt(System.console().readLine());
                boolean gender = Boolean.parseBoolean(System.console().readLine());
                double salary = Double.parseDouble(System.console().readLine());
                String companyName = System.console().readLine();
                Company company = null;
                if (!companyName.equals("null")) {
                    company = new Company(companyName);
                }
                Employee employee = new Employee(name, age, gender, salary, company);
                personList.add(employee);
                empList.add(employee);
            } else {
                break;
            }
        }
        Collections.sort(personList);
        System.out.println("stuList");
        for (Student student : stuList) {
            System.out.println(student.toString());
        }
        System.out.println("empList");
        for (Employee employee : empList) {
            System.out.println(employee.toString());
        }
    }
}
/*
Employee:bo-18-true-IBM-5000.54
Employee:bo-25-true-IBM-5000.51
Employee:bo-25-true-IBM-5000.52
Employee:hua-16-false-null-1000.0
Employee:hua-16-false-null-1000.0
Employee:hua-18-false-MicroSoft-1234.0
Employee:tan-25-true-IBM-5000.56
Employee:tan-25-true-IBM-5000.51
Student:wang-17-false-002-null
Student:wang-17-false-002-null
Student:wang-17-false-002-net16
Employee:wang-18-true-IBM-3000.51
Student:zhang-23-false-001-net15
Student:zhang-23-false-001-net15
stuList
Student:wang-17-false-002-null
Student:wang-17-false-002-net16
Student:zhang-23-false-001-net15
empList
Employee:bo-18-true-IBM-5000.54
Employee:bo-25-true-IBM-5000.51
Employee:hua-16-false-null-1000.0
Employee:hua-18-false-MicroSoft-1234.0
Employee:tan-25-true-IBM-5000.56
Employee:tan-25-true-IBM-5000.51
Employee:wang-18-true-IBM-3000.51

*/

