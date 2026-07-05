package DesignPatterns.State;

public class YellowTrafficState implements TrafficLightState{
    @Override
    public void change(TrafficLight trafficLight) {
        System.out.println("Need to wait as traffic light is yellow");
        trafficLight.changeState(new GreenTrafficState());
    }

    @Override
    public String getColor() {
        return "YELLOW";
    }
}
