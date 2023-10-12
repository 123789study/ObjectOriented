package demo111;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        ArrayList<PersonOverride> persons1 = new ArrayList<>();
        int n1 = scanner.nextInt();
        for (int i = 0; i < n1; i++) {
            persons1.add(new PersonOverride());
        }

        ArrayList<PersonOverride> persons2 = new ArrayList<>();
        int n2 = scanner.nextInt();
        for (int i = 0; i < n2; i++) {

            PersonOverride person = new PersonOverride(scanner.next(), scanner.nextInt(), scanner.nextBoolean());
            if (!persons2.contains(person)) {
                persons2.add(person);
            }
        }

        for (PersonOverride person : persons1) {
            System.out.println(person);
        }

        for (PersonOverride person : persons2) {
            System.out.println(person);
        }

        System.out.println(persons2.size());

        StringJoiner sb=new StringJoiner(", ","[","]");
        final var objects = Arrays.stream(PersonOverride.class.getConstructors()).toArray();
        for (int i = objects.length - 1; i >= 0; i--) {
            sb.add(objects[i].toString());
        }
        System.out.println(sb);

    }
}

class PersonOverride {
    private String name;
    private int age;
    private boolean gender;

    public PersonOverride(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public PersonOverride() {
        this("default", 1, true);
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
        PersonOverride person = (PersonOverride) obj;
        return age == person.age && gender == person.gender && Objects.equals(name, person.name);
    }
}