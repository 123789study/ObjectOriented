package demo111.demo22;

class F{
    public F(){ System.out.print("F() is called!"); } 
} 
class S extends F{ 
    public S(){ System.out.print("S() is called!"); } 
} 
public class Test{ 
    public static void main(String args[]){ 
        S sa=new S(); 
    } 
}