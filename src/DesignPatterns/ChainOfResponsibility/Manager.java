package DesignPatterns.ChainOfResponsibility;

public class Manager extends RequestHandler{
    int id;

    public Manager(String name) {
        super(name);
    }

    @Override
    public void setNextHandler(RequestHandler nextHandler) {
        super.setNextHandler(nextHandler);
    }

    @Override
    public void handleRequest(int id) {
        if (id>=1 && id<10)
            System.out.println("Permission given by Manager");
        else
            super.handleRequest(id);
    }
}
