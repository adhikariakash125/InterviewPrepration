package LLD.Elevator;

import LLD.Elevator.entity.Elevator;
import LLD.Elevator.entity.Request;
import LLD.Elevator.enums.Direction;
import LLD.Elevator.enums.Source;
import LLD.Elevator.observer.ElevatorDisplay;
import LLD.Elevator.stratergy.ElevatorSelectionStrategy;
import LLD.Elevator.stratergy.NearestElevatorStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ElevatorSystem {
    private static volatile ElevatorSystem instance;

    public Map<Integer, Elevator> elevatorMap;
    public ElevatorSelectionStrategy selectionStrategy;
    private final ExecutorService executorService;

    public ElevatorSystem(int numberOfElevators) {
        this.elevatorMap = new HashMap<>();
        this.selectionStrategy = new NearestElevatorStrategy();
        this.executorService = Executors.newFixedThreadPool(numberOfElevators);
        ElevatorDisplay elevatorDisplay = new ElevatorDisplay();
        List<Elevator> elevatorList = new ArrayList<>();
        for (int i = 1; i <= numberOfElevators; i++) {
            Elevator elevator = new Elevator(i);
            elevator.addObserver(elevatorDisplay);
            elevatorList.add(elevator);
            elevatorMap.put(elevator.getId(), elevator);
        }
//        this.elevatorMap = elevatorList.stream().collect(Collectors.toMap(Elevator::getId,e -> e));
    }

    public static synchronized ElevatorSystem getInstance(int numberOfElevators) {
        if (instance == null) {
            synchronized (ElevatorSystem.class) {
                if (instance == null) {
                    instance = new ElevatorSystem(numberOfElevators);
                }
            }
        }
        return instance;
    }

    public void start() {
        for (Elevator elevator : elevatorMap.values())
            executorService.submit(elevator);
    }

    public void requestElevator(int targetFloor, Direction direction) {
        System.out.println("\n>> EXTERNAL Request: User at floor " + targetFloor + " wants to go " + direction);
        Request request = new Request(direction, Source.EXTERNAL, targetFloor);
        Elevator elevator = selectionStrategy.selectElevator(elevatorMap.values().stream().toList(), request);
        if (elevator != null) {
            elevator.addRequest(request);
        } else System.out.println("All elevator are busy...try after sometime");
    }

    // INTERNAL CALL
    public void selectFloor(int destinationFloor, int elevatorId) {
        System.out.println("\n>> INTERNAL Request: User in Elevator " + elevatorId + " selected floor " + destinationFloor);
        Elevator elevator = elevatorMap.get(elevatorId);
        if (elevator != null) {
            Request request = new Request(Direction.IDLE, Source.EXTERNAL, destinationFloor);
            elevator.addRequest(request);
        } else System.out.println("Wrong elevator id");
    }

    public void shutdown() {
        System.out.println("Shutting down elevator system...");
        for (Elevator elevator : elevatorMap.values()) {
            elevator.stopElevator();
        }
        executorService.shutdown();
    }
}
