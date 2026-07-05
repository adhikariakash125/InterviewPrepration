package LLD.Elevator.entity;

import LLD.Elevator.enums.Direction;
import LLD.Elevator.enums.Source;

public class Request {
    private Direction direction;
    private Source reqSource;
    private int targetFloor;

    public Request(Direction direction, Source reqSource, int targetFloor) {
        this.direction = direction;
        this.reqSource = reqSource;
        this.targetFloor = targetFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Source getReqSource() {
        return reqSource;
    }

    public void setReqSource(Source reqSource) {
        this.reqSource = reqSource;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    @Override
    public String toString() {
        return "Request{" +
                "direction=" + direction +
                ", reqSource=" + reqSource +
                ", targetFloor=" + targetFloor +
                '}';
    }
}
