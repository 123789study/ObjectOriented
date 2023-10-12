package demo111.demo14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        Person[] people=new Person[length];

        for (int i = 0; i < length; i++) {
            people[i]=new Person(sc.next(),sc.nextInt());
        }

        String search=sc.next();

        boolean flag=true;

        for (Person person : people) {
            System.out.println(person);
        }

        for (Person person : people) {
            if (search.equals(person.getName())) {
                System.out.println("查询结果");
                System.out.println(person);
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println("not found");
        }

    }
}

class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "none";
        this.age = 1;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 获取
     *
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * 设置
     *
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * 获取
     *
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * 设置
     *
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * 获取
     *
     * @return day
     */
    public int getDay() {
        return day;
    }

    /**
     * 设置
     *
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    public void print() {
        System.out.print(month + "/" + day + "/" + year + " ");
    }

    public int compare(MyDate d) {
        return (getYear() + "" + getMonth() + "" + getMonth()).compareTo(d.getYear() + "" + d.getMonth() + "" + d.getMonth());
    }

    public String toString() {
        return "MyDate{year = " + year + ", month = " + month + ", day = " + day + "}";
    }
}


class Employee {
    private String name;
    private String ID;


    public Employee() {
    }

    public Employee(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }

    public double getSalary() {
        return 0;
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
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * 设置
     *
     * @param ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Employee{name = " + name + ", ID = " + ID + "}";
    }
}

class SalariedEmployee extends Employee {
    private double MoneyPerMonth;

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, String ID, double MoneyPerMonth) {
        super(name, ID);
        this.MoneyPerMonth = MoneyPerMonth;
    }

    @Override
    public String toString() {
        return "SalariedEmployee[name=" + getName() + ",id=" + getID() + "][monthSalary=" + getSalary() + "]";
    }

    @Override
    public double getSalary() {
        return MoneyPerMonth;
    }
}

class HourlyEmployee extends Employee {
    private Double MoneyPerHour;
    private Double Hour;

    public HourlyEmployee(String name, String ID, double moneyPerHour, double hour) {
        super(name, ID);
        MoneyPerHour = moneyPerHour;
        Hour = hour;
    }

    public HourlyEmployee() {
    }

    public HourlyEmployee(Double MoneyPerHour, Double Hour) {
        this.MoneyPerHour = MoneyPerHour;
        this.Hour = Hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee[name=" + getName() + ",id=" + getID() + "][hourSalary=" + getMoneyPerHour() + ",workhour=" + getHour() + "]";
    }

    @Override
    public double getSalary() {
        return MoneyPerHour * Hour;
    }

    /**
     * 获取
     *
     * @return MoneyPerHour
     */
    public Double getMoneyPerHour() {
        return MoneyPerHour;
    }

    /**
     * 设置
     *
     * @param MoneyPerHour
     */
    public void setMoneyPerHour(Double MoneyPerHour) {
        this.MoneyPerHour = MoneyPerHour;
    }

    /**
     * 获取
     *
     * @return Hour
     */
    public Double getHour() {
        return Hour;
    }

    /**
     * 设置
     *
     * @param Hour
     */
    public void setHour(Double Hour) {
        this.Hour = Hour;
    }
}

class CommissionEmployee extends Employee {
    private double rate;
    private double total;

    public CommissionEmployee(double rate, double total) {
        this.rate = rate;
        this.total = total;
    }

    public CommissionEmployee(String name, String ID, double rate, double total) {
        super(name, ID);
        this.rate = rate;
        this.total = total;
    }

    public CommissionEmployee() {
    }

    @Override
    public String toString() {
        return "CommissionEmployee[name=" + getName() + ",id=" + getID() + "][commissionRatio=" + getRate() + ",sale=" + getTotal() + "]";
    }

    @Override
    public double getSalary() {
        return rate * total;
    }

    /**
     * 获取
     *
     * @return rate
     */
    public double getRate() {
        return rate;
    }

    /**
     * 设置
     *
     * @param rate
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * 获取
     *
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * 设置
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }
}


