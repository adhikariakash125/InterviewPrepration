package LLD.ConcertTicketBooking;

import LLD.ConcertTicketBooking.entity.Booking;
import LLD.ConcertTicketBooking.entity.Concert;
import LLD.ConcertTicketBooking.entity.Seats;
import LLD.ConcertTicketBooking.entity.User;
import LLD.ConcertTicketBooking.enums.BookingStatus;
import LLD.ConcertTicketBooking.enums.SeatStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ConcertBookingSystem {
    private static ConcertBookingSystem concertBookingSystem;
    private HashMap<String, Concert> concerts;
    private HashMap<String, Booking> bookings;
    private final Object lock = new Object();

    public ConcertBookingSystem() {
        this.concerts = new HashMap<>();
        this.bookings = new HashMap<>();
    }

    public static synchronized ConcertBookingSystem getInstance(){
        if (concertBookingSystem==null){
            concertBookingSystem = new ConcertBookingSystem();
        }
        return concertBookingSystem;
    }

    public void addConcert(Concert concert){
        concerts.put(concert.getId(),concert);
    }

    public Concert getConcert(String id){
        return concerts.get(id);
    }

    public void addBooking(Booking booking){
        bookings.put(booking.getId(),booking);
    }

    public Booking getBooking(String id){
        return bookings.get(id);
    }

    public List<Concert> searchConcerts(String artistName, String venue, LocalDateTime localDateTime){
        return concerts.values().stream()
                .filter(concert -> concert.getArtistName().equals(artistName) &&
                        concert.getVenue().equals(venue) &&
                        concert.getDate().isBefore(localDateTime))
                .collect(Collectors.toList());
    }

    public Booking bookTicket(User user, Concert concert, List<Seats> seats){
        Concert concertToBook = concerts.get(concert.getId());
        if (concertToBook==null) return null;
        synchronized (lock){
            for (Seats seat : seats){
                if (!seat.getStatus().equals(SeatStatus.AVAILABLE))
                    return null;
            }
            Seats.bookSeats(seats);
            String bookingId = generateBookingId();
            int totalPrice = seats.stream().mapToInt(s -> s.getPrice()).sum();
            Booking booking = new Booking(bookingId, totalPrice, seats, user);
            bookings.put(bookingId, booking);
            if(processPayment(totalPrice)){
                booking.setBookingStatus(BookingStatus.CONFIRMED);
            }
            return booking;
        }
    }

    public void cancelBooking(String bookingId){
        Booking booking = bookings.get(bookingId);
        if (booking==null) throw new RuntimeException("No Booking Id found for cancellation");
        booking.cancelBooking();
        bookings.remove(bookingId);
    }

    private boolean processPayment(int totalPrice) {
        return true;
    }

    private String generateBookingId(){
        return "BKG" + UUID.randomUUID();
    }
}
