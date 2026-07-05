package DesignPatterns.State;

public interface TrafficLightState {
    void change(TrafficLight trafficLight);
    String getColor();
}
