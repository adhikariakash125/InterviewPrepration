package DesignPatterns.ChainOfResponsibility;

public class ChainClassDemo {
    public static void main(String[] args) {
        RequestHandler manager = new Manager("Manager");
        RequestHandler vicePresident = new VicePresident("VicePresident");
        RequestHandler director = new Director("Director");
        manager.setNextHandler(vicePresident);
        vicePresident.setNextHandler(director);

        manager.handleRequest(15);
        manager.handleRequest(101);
        manager.handleRequest(67);
        manager.handleRequest(8);
    }
}
