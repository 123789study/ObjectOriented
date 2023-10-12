package demo111.demo4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();
        try {
            Triangle t = new Triangle(s1,s2,s3);
            System.out.println(t);
        }
        catch (IllegalTriangleException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Triangle{
    private double s1;
    private double s2;
    private double s3;

    public Triangle() {
    }

    public Triangle(double s1, double s2, double s3) throws IllegalTriangleException {
        if (s1+s2<=s3||s1+s3<=s2||s2+s3<=s1){
            throw new IllegalTriangleException("Invalid: "+s1+","+s2+","+s3);
        }
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public String toString() {
        return "Triangle [side1=" + s1 + ", side2=" + s2 + ", side3=" + s3 + "]";
    }
}

class IllegalTriangleException extends Exception {

    public IllegalTriangleException(String message) {
        super(message);
    }
}

