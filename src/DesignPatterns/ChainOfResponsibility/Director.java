package DesignPatterns.ChainOfResponsibility;

public class Director extends RequestHandler{
    public Director(String name) {
        super(name);
    }

    @Override
    public void setNextHandler(RequestHandler nextHandler) {
        super.setNextHandler(nextHandler);
    }

    @Override
    public void handleRequest(int id) {
        if (id>=50 && id<100) System.out.println("Access given by director");
        else super.handleRequest(id);
    }
}
