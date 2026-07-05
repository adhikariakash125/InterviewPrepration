package LLD.Elevator.stratergy;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {
    Elevator selectElevator(List<Elevator> elevators, Request request);
}
