package LLD.Elevator.observer;

import LLD.Elevator.entity.Elevator;

public class ElevatorDisplay implements ElevatorObserver{
    @Override
    public void update(Elevator elevator) {
        System.out.println("DISPLAY | elevator id: " + elevator.getId() +
                " | floor number: " + elevator.getCurrentFloor() +
                "| direction: " + elevator.getDirection());
    }
}
