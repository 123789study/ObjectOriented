package demo111.demo3;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();
        Animal goat = new Goat();
        speak(cat);
        speak(dog);
        speak(goat);
    }
    //定义静态方法speak()
    public static void speak(Animal animal){
        System.out.println(animal.getAnimalClass()+"的叫声: "+animal.shout());
    }

}

//定义抽象类Animal
abstract class Animal {
    public abstract String shout();
    public abstract String getAnimalClass();
}

//基于Animal类，定义猫类Cat，并重写两个抽象方法
class Cat extends Animal{

    @Override
    public String shout() {
        return "喵喵";
    }

    @Override
    public String getAnimalClass() {
        return "猫";
    }
}

//基于Animal类，定义狗类Dog，并重写两个抽象方法
class Dog  extends Animal{
    @Override
    public String shout() {
        return "汪汪";
    }

    @Override
    public String getAnimalClass() {
        return "狗";
    }
}

//基于Animal类，定义山羊类Goat，并重写两个抽象方法
class Goat  extends Animal{


    @Override
    public String shout() {
        return "咩咩";
    }

    @Override
    public String getAnimalClass() {
        return "山羊";
    }
}
