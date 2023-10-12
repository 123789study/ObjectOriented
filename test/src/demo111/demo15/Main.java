package demo111.demo15;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n1=scanner.nextInt();
        int n2=scanner.nextInt();
        PersonOverride[] person1=new PersonOverride[n1];

        for (int i = 0; i < n1; i++) {
            person1[i]=new PersonOverride();
        }

        PersonOverride[] person2=new PersonOverride[n2];

        for (int i = 0; i < n2; i++) {
            String name=scanner.next();
            int age=scanner.nextInt();
            boolean gender=scanner.nextBoolean();

            boolean flag=true;
            var personOverride = new PersonOverride(name, age, gender);

            for (int i1 = 0; i1 < person2.length; i1++) {
                if (person2[i1].equals(personOverride)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                person2[i]=personOverride;
            }
        }
        Arrays.stream(person1).forEach(s-> System.out.println(s));
    }
}


class PersonOverride{
    private String name;
    private int age;
    private boolean gender;

    public PersonOverride() {
        this("default",1,true);
    }

    public PersonOverride(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public boolean isGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String toString() {
        return  name + "-" + age + "-" + gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonOverride that = (PersonOverride) o;
        return age == that.age && gender == that.gender && Objects.equals(name, that.name);
    }
}

