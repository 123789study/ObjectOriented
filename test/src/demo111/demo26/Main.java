package demo111.demo26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = scanner.nextInt();
        List<PersonOverride> persons1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            persons1.add(new PersonOverride());
        }

        int n2 = scanner.nextInt();
        List<PersonOverride> persons2 = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            String name = scanner.next();
            int age = scanner.nextInt();
            boolean gender = scanner.nextBoolean();
            PersonOverride person = new PersonOverride(name, age, gender);
            if (!persons2.contains(person)) {
                persons2.add(person);
            }
        }
        persons1.stream().forEach(System.out::println);

      /*  for (PersonOverride person : persons1) {
            System.out.println(person);
        }*/

        for (PersonOverride person : persons2) {
            System.out.println(person);
        }

        // 输出persons2中实际包含的对象的数量
        System.out.println(persons2.size());

        // 使用System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));输出PersonOverride的所有构造方法
        System.out.println(Arrays.toString(PersonOverride.class.getConstructors()));
    }
}

class PersonOverride {
    private String name;
    private int age;
    private boolean gender;

    public PersonOverride() {
        this("default", 1, true);
    }

    public PersonOverride(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + "-" + age + "-" + gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PersonOverride other = (PersonOverride) obj;
        return name.equals(other.name) && age == other.age && gender == other.gender;
    }
}
