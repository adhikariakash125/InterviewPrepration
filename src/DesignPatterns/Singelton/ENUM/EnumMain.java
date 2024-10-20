package DesignPatterns.Singelton.ENUM;

public class EnumMain {
    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum.getValue());
        singletonEnum.setValue(45);
        System.out.println(singletonEnum.getValue());
    }
}
