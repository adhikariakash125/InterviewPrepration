package LLD.Elevator.state;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;
import LLD.Elevator.enums.Direction;
import LLD.Elevator.enums.Source;

public class MovingDownState implements ElevatorState {
    @Override
    public void addRequest(Elevator elevator, Request request) {
        // INTERNAL
        if (request.getReqSource() == Source.INTERNAL) {
            if (elevator.getCurrentFloor() >= request.getTargetFloor())
                elevator.getDownRequests().add(request.getTargetFloor());
            else if (elevator.getCurrentFloor() < request.getTargetFloor())
                elevator.getUpRequests().add(request.getTargetFloor());
            return;
        }
        //EXTERNAL
        if (elevator.getDirection() == Direction.DOWN && request.getTargetFloor() < elevator.getCurrentFloor()) {
            elevator.getDownRequests().add(request.getTargetFloor());
        } else if (elevator.getDirection() == Direction.UP)
            elevator.getUpRequests().add(request.getTargetFloor());

    }

    @Override
    public Direction getDirection() {
        return Direction.DOWN;
    }

    @Override
    public void move(Elevator elevator) {
        if (elevator.getDownRequests().isEmpty()){
            elevator.setState(new IdleState());
            return;
        }
        int targetFloor = elevator.getDownRequests().first();
        elevator.setCurrentFloor(elevator.getCurrentFloor()-1);
        System.out.println("Elevator " + elevator.getId() + " stopped at floor " + elevator.getCurrentFloor());
        if (elevator.getCurrentFloor()==targetFloor){
            elevator.getDownRequests().pollFirst();
        }
        if (elevator.getDownRequests().isEmpty()){
            elevator.setState(new IdleState());
        }
    }
}
