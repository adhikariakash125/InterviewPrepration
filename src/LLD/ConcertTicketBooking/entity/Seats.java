package LLD.ConcertTicketBooking.entity;

import LLD.ConcertTicketBooking.enums.SeatStatus;
import LLD.ConcertTicketBooking.enums.SeatType;

import java.util.List;

public class Seats {
    private int id;
    private String seatNumber;
    private SeatStatus status;
    private SeatType seatType;
    private int price;

    public Seats(int id, String seatNumber, SeatStatus status, SeatType seatType, int price) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.status = status;
        this.seatType = seatType;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static synchronized void bookSeats(List<Seats> seats){
        seats.forEach(s -> s.setStatus(SeatStatus.BOOKED));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
