package demo111.demo19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.pow;

public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List list = new ArrayList();

        double SUMAllPerimete = 0;
        double SUMALLArea = 0;

        int NUMBER = sc.nextInt();

        for (int i = 0; i < NUMBER; i++) {

            String shape = sc.next();
            if (shape.equals("rect")) {
                int length = sc.nextInt();
                int width = sc.nextInt();
                Rectangle rectangle = new Rectangle(length, width);

                list.add(rectangle);

                SUMAllPerimete += rectangle.getPerimeter();
                SUMALLArea += rectangle.getArea();

            } else if (shape.equals("cir")) {
                int radius = sc.nextInt();
                Circle circle = new Circle(radius);

                list.add(circle);

                SUMAllPerimete += circle.getPerimeter();
                SUMALLArea += circle.getArea();
            }

        }

        System.out.println(SUMAllPerimete);
        System.out.println(SUMALLArea);

        StringBuilder sb = new StringBuilder();

        for (Object o : list) {
            if (o instanceof Rectangle) {
                sb.append("demo111.demo19.Rectangle " + "[width=" + ((Rectangle) o).getWidth() + ", length=" + ((Rectangle) o).getLength() + "], ");
            }
            if (o instanceof Circle) {
                sb.append("demo111.demo19.Circle [radius=" + ((Circle) o).getRadius() + "], ");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);

        System.out.println("[" + sb + "]");

        for (Object o : list) {
            System.out.println(o.getClass() + "," + o.getClass().getSuperclass());
        }
    }
}

abstract class Shape {
    static double PI = 3.14;

    public abstract double getPerimeter();

    public abstract double getArea();
}

class Rectangle extends Shape {

    private int width;
    private int length;


    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle() {
    }

    @Override
    public String toString() {
        return "demo111.demo19.Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double getArea() {
        return length * width;
    }

    /**
     * 获取
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取
     *
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * 设置
     *
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    @Override
    public String toString() {
        return "demo111.demo19.Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double getArea() {
        return PI * pow(radius, 2);
    }

    /**
     * 获取
     *
     * @return radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * 设置
     *
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
