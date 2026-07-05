package LLD.Elevator.state;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;
import LLD.Elevator.enums.Direction;

public interface ElevatorState {
    void addRequest(Elevator elevator, Request request);
    Direction getDirection();
    void move(Elevator elevator);
}
