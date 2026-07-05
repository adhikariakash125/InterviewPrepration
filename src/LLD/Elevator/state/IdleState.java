package LLD.Elevator.state;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;
import LLD.Elevator.enums.Direction;

public class IdleState implements ElevatorState {
    @Override
    public void addRequest(Elevator elevator, Request request) {
        if (elevator.getCurrentFloor() < request.getTargetFloor())
            elevator.getUpRequests().add(request.getTargetFloor());
        else if (elevator.getCurrentFloor() > request.getTargetFloor())
            elevator.getDownRequests().add(request.getTargetFloor());
    }

    @Override
    public Direction getDirection() {
        return Direction.IDLE;
    }

    @Override
    public void move(Elevator elevator) {
        if (!elevator.getUpRequests().isEmpty()) {
            elevator.setState(new MovingUpState());
        } else if (!elevator.getDownRequests().isEmpty()) {
            elevator.setState(new MovingDownState());
        }
        // for idle state do nothing
    }
}
