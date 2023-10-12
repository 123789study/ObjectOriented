package demo111.demo22;
class Base {
    static void test() {
        System.out.println("Base.demo111.demo111.test()");
    }
}

class Child extends Base {
    static void test() {
        System.out.println("Child.demo111.demo111.test()");
        Base.test();     // Call the parent method
    }
}

public class Main {
    public static void main(String[] a) {
        Child.test();
    }
}
