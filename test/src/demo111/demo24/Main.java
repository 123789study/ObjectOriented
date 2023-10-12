package demo111.demo24;

class Father {
    int a = 100;
    int b = 200;

    public void print() {
        System.out.println(a + " " + b);
    }
}

class Child extends Father {
    int b = 300;
    int c = 400;

    public void print() {
        System.out.println(a + " " + b + " " + c);
    }

    public void printExtend() {
        System.out.println(c);
    }

}

public class Main {
    public static void main(String[] a) {
          Father obj=new Child();
          System.out.println(obj.a+" "+obj.b);   
          obj.print();  
    }
}