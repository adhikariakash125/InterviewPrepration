package DesignPatterns.State;

public class TrafficLightDemo {
    public static void main(String[] args) throws InterruptedException {
        TrafficLight trafficLight = new TrafficLight(10);
        for (int i=0;i<6;i++){
            trafficLight.change();
            Thread.sleep(trafficLight.getWaitingTime());
        }
    }
}
