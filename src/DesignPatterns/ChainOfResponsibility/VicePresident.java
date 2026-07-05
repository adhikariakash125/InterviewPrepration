package DesignPatterns.ChainOfResponsibility;

public class VicePresident extends RequestHandler{
    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void setNextHandler(RequestHandler nextHandler) {
        super.setNextHandler(nextHandler);
    }

    @Override
    public void handleRequest(int id) {
        if (id>=10 && id<50) System.out.println("Access given by VP");
        else super.handleRequest(id);
    }
}
