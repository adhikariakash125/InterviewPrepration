package DesignPatterns.State;

public class TrafficLight {
    private int waitingTime;
    private TrafficLightState trafficLightState;

    public TrafficLight(int waitingTime) {
        this.waitingTime = waitingTime;
        this.trafficLightState = new RedTrafficState();
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public TrafficLightState getTrafficLightState() {
        return trafficLightState;
    }

    public void setTrafficLightState(TrafficLightState trafficLightState) {
        this.trafficLightState = trafficLightState;
    }

    public void change(){
        trafficLightState.change(this);
    }

    public void changeState(TrafficLightState trafficLightState) {
        System.out.println("Transition from " + this.trafficLightState.getColor());
        this.trafficLightState = trafficLightState;
    }
}
