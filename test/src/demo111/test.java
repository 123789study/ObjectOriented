package demo111;

public class test {
    public static void main(String[] args) {
        A1 a1=new A1();
        a1.setx(4);
        a1.printa();

        B1 b1=new B1();
        b1.printa();
        b1.printb();

        b1.setx(6);
        b1.printb();
        b1.printa();
        a1.printa();
    }
}
class A1{
    int x=2;
    public void setx(int i){
        x=i;
    }
    void printa(){
        System.out.println(x);
    }
}
class B1 extends A1{
    int x=100;
    void  printb(){
        super.x=super.x+10;
        System.out.println("super.x="+super.x+" x="+x);
    }
}

