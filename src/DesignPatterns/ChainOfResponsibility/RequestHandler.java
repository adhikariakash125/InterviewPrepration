package DesignPatterns.ChainOfResponsibility;

public abstract class RequestHandler {

    protected RequestHandler nextHandler;
    protected String name;

    public RequestHandler(String name) {
        this.name = name;
    }

    public void setNextHandler(RequestHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleRequest(int id){
        if(nextHandler!=null){
            nextHandler.handleRequest(id);
        }else{
            System.out.println("Request cannot be approved");
        }
    }
}
