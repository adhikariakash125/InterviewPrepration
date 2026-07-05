package LLD.ConcertTicketBooking.entity;

import LLD.ConcertTicketBooking.enums.BookingStatus;
import LLD.ConcertTicketBooking.enums.SeatStatus;
import LLD.ConcertTicketBooking.enums.SeatType;

import java.util.List;

public class Booking {
    private String id;
    private double totalAmount;
    private List<Seats> seats;
    private User user;
    private BookingStatus bookingStatus;

    public Booking(String id, double totalAmount, List<Seats> seats, User user) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.seats = seats;
        this.user = user;
        this.bookingStatus = BookingStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public void cancelBooking() {
        if (bookingStatus==BookingStatus.CONFIRMED){
            setBookingStatus(BookingStatus.CANCELLED);
        }
        for (Seats seat : seats){
            seat.setStatus(SeatStatus.AVAILABLE);
        }
    }
}
