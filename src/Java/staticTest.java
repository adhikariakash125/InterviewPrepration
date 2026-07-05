package Java;

import java.io.Serializable;

class PareentClass {

    public static void display(){
        System.out.println("from super class");
    }

}

class ChildClass extends PareentClass {

    public static void display(){
        System.out.println("from child class");
    }
}
public class staticTest{
    public static void main(String[] args) {
        PareentClass obj = new ChildClass();
        obj.display();
//        staticTestSubclass.display();

    }
}