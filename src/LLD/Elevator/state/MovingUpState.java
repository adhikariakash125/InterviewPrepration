package LLD.Elevator.state;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;
import LLD.Elevator.enums.Direction;
import LLD.Elevator.enums.Source;

public class MovingUpState implements ElevatorState {
    @Override
    public void addRequest(Elevator elevator, Request request) {
        if (request.getReqSource() == Source.INTERNAL) {
            if (elevator.getCurrentFloor() < request.getTargetFloor())
                elevator.getUpRequests().add(request.getTargetFloor());
            else
                elevator.getDownRequests().add(request.getTargetFloor());
            return;
        }
        if (request.getDirection() == Direction.UP && request.getTargetFloor()>=elevator.getCurrentFloor())
            elevator.getUpRequests().add(request.getTargetFloor());
        if (request.getDirection() == Direction.DOWN)
            elevator.getDownRequests().add(request.getTargetFloor());

    }

    @Override
    public Direction getDirection() {
        return Direction.UP;
    }

    @Override
    public void move(Elevator elevator) {
        if (elevator.getUpRequests().isEmpty()){
            elevator.setState(new IdleState());
            return;
        }
        int targetFloor = elevator.getUpRequests().getFirst();
        int currentFloor = elevator.getCurrentFloor();
        elevator.setCurrentFloor(currentFloor+1);
        System.out.println("Elevator " + elevator.getId() + " stopped at floor " + currentFloor+1);
        if (elevator.getCurrentFloor()==targetFloor){
            elevator.getUpRequests().pollFirst();
        }
        if (elevator.getUpRequests().isEmpty())
            elevator.setState(new IdleState());
    }
}
