package DesignPatterns.State;

public class RedTrafficState implements TrafficLightState{
    @Override
    public void change(TrafficLight trafficLight) {
        System.out.println("Need to STOP...as traffic light is RED");
        trafficLight.changeState(new YellowTrafficState());
    }

    @Override
    public String getColor() {
        return "RED";
    }
}
