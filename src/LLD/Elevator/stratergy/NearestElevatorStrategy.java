package LLD.Elevator.stratergy;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;
import LLD.Elevator.enums.Direction;

import java.util.List;

public class NearestElevatorStrategy implements ElevatorSelectionStrategy{
    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Direction direction = request.getDirection();
        int targetFloor = request.getTargetFloor();
        Elevator nearestElevator = null;
        int minDistance = 10000;
        for (Elevator elevator : elevators){
            if (isSuitable(elevator,request)) {
                int dist = Math.abs(elevator.getCurrentFloor()-targetFloor);
                if (dist<minDistance){
                    minDistance = dist;
                    nearestElevator = elevator;
                }
            }
        }
        return nearestElevator;
    }

    public boolean isSuitable(Elevator elevator, Request request){
        if (elevator.getDirection()==Direction.IDLE) {
            return true;
        }
        else if (elevator.getDirection()==request.getDirection()){
            if (elevator.getDirection() == Direction.UP && elevator.getCurrentFloor()<= request.getTargetFloor())
                return true;
            else if (elevator.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= request.getTargetFloor())
                return true;
        }
        return false;
    }
}
