package LLD.Elevator.entity;

import LLD.Elevator.enums.Direction;
import LLD.Elevator.observer.ElevatorDisplay;
import LLD.Elevator.observer.ElevatorObserver;
import LLD.Elevator.state.ElevatorState;
import LLD.Elevator.state.IdleState;
import LLD.Elevator.stratergy.ElevatorSelectionStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator implements Runnable {
    private int id;
    private AtomicInteger currentFloor;
    private ElevatorState state;
    private volatile boolean isRunning = true;
    private final TreeSet<Integer> upRequests;
    private final TreeSet<Integer> downRequests;

    //List of Observers
    List<ElevatorObserver> elevatorObservers = new ArrayList<>();

    @Override
    public void run() {
        while (isRunning) {
            move();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }

    public void move() {
        state.move(this);
    }

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = new AtomicInteger(1);
        this.upRequests = new TreeSet<>();
        this.downRequests = new TreeSet<>((a, b) -> b - a);
        this.state = new IdleState();
    }

    public synchronized void addRequest(Request request){
        System.out.println("Elevator " + id + " processing: " + request);
        state.addRequest(this, request);
    }

    public void notifyObservers() {
        for (ElevatorObserver observer : elevatorObservers) {
            observer.update(this);
        }
    }

    public Direction getDirection() {
        return state.getDirection();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor.get();
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor.set(currentFloor);
        notifyObservers();
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
        notifyObservers();
    }

    public boolean isRunning() {
        return isRunning;
    }

    public TreeSet<Integer> getUpRequests() {
        return upRequests;
    }

    public TreeSet<Integer> getDownRequests() {
        return downRequests;
    }

    public void addObserver(ElevatorObserver observer) {
        elevatorObservers.add(observer);
        observer.update(this);
    }

    public void stopElevator() {
        this.isRunning = false;
    }
}
