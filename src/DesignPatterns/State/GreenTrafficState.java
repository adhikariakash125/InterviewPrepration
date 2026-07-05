package DesignPatterns.State;

public class GreenTrafficState implements TrafficLightState{

    @Override
    public void change(TrafficLight trafficLight) {
        System.out.println("You can now GO...traffic light is green");
        trafficLight.changeState(new RedTrafficState());
    }

    @Override
    public String getColor() {
        return "GREEN";
    }
}
