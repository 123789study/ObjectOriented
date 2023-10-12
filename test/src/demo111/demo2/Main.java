package demo111.demo2;


interface USB {
    void work();

    void stop();
}

class Mouse implements USB {

    @Override
    public void work() {
        System.out.println("我点点点");
    }

    @Override
    public void stop() {
        System.out.println("我不能点了");
    }
}

class UPan implements USB {

    @Override
    public void work() {
        System.out.println("我存存存");
    }

    @Override
    public void stop() {
        System.out.println("我走了");
    }
}

public class Main {
    public static void main(String[] args) {
        USB usb1 = new Mouse();
        usb1.work();
        usb1.stop();
        USB[] usbs = new USB[2];
        usbs[0]=new UPan();
        usbs[1]=new Mouse();

        for (USB usb : usbs) {
            usb.work();
            usb.stop();
        }
    }
}

interface Biology {
    void breathe();
}

interface Animal {
    void eat();

    void sleep();
}

class Person implements Biology, Animal {
    @Override
    public void breathe() {
        System.out.println("我喜欢呼吸新鲜空气");
    }

    @Override
    public void eat() {
        System.out.println("我会按时吃饭");
    }

    @Override
    public void sleep() {
        System.out.println("早睡早起身体好");
    }

    public void think() {
        System.out.println("我喜欢思考");
    }
}

class Pupil extends Person {
    private String school;

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }
}

/*public class demo111.demo18.demo111.demo19.demo111.Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pupil zhangsan = new Pupil();
        String schoolName = scanner.nextLine();
        zhangsan.setSchool(schoolName);

        System.out.println("我的学校是" + zhangsan.getSchool());
        zhangsan.breathe();
        zhangsan.eat();
        zhangsan.sleep();
        zhangsan.think();
    }
}*/


