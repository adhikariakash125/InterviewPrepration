package LLD.ConcertTicketBooking;

import LLD.ConcertTicketBooking.entity.Booking;
import LLD.ConcertTicketBooking.entity.Concert;
import LLD.ConcertTicketBooking.entity.Seats;
import LLD.ConcertTicketBooking.entity.User;
import LLD.ConcertTicketBooking.enums.SeatStatus;
import LLD.ConcertTicketBooking.enums.SeatType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConcertTicketBookingDemo {
    public static void main(String[] args) {

        // Create concert ticket booking system instance
        ConcertBookingSystem concertBookingSystem = ConcertBookingSystem.getInstance();

        // Create users
        User user = new User("Akash", "yop@mail.com");
        User jc = new User("JC", "JC@gmail.com");

        // Create concerts
        List<Seats> concertSeats = generateSeats(100);
        Concert concert = new Concert("Concert-1", "BM-WorldTour", "BrunoMars",
                concertSeats,
                LocalDateTime.now().plusDays(30),
                "WTP");

        List<Seats> concertSeats2 = generateSeats(50);
        Concert concert2 = new Concert("Concert-2", "Undekhi", "Anuv Jain",
                concertSeats2,
                LocalDateTime.now().plusMonths(2),
                "Phoenix");

        concertBookingSystem.addConcert(concert);
        concertBookingSystem.addConcert(concert2);

        // search concerts
        List<Concert> concerts = concertBookingSystem.searchConcerts("BrunoMars", "WTP", LocalDateTime.now().plusMonths(5));
        System.out.println("Search Results:");
        for (Concert c : concerts) {
            System.out.println("Concert: " + c.getArtistName() + " at " + c.getVenue());
        }

        // Book tickets
        List<Seats> seats = selectSeats(concert, 3);
        Booking booking = concertBookingSystem.bookTicket(user, concert, seats);

        List<Seats> selectedSeats2 = selectSeats(concert2, 2);
        Booking booking2 = concertBookingSystem.bookTicket(jc, concert2, selectedSeats2);

        // Cancel booking
        concertBookingSystem.cancelBooking(booking2.getId());

        // Book tickets again
        List<Seats> selectedSeats3 = selectSeats(concert, 2);
        Booking booking3 = concertBookingSystem.bookTicket(jc, concert, selectedSeats3);
    }


    public static List<Seats> generateSeats(int number){
        List<Seats> seats = new ArrayList<>();
        for (int i=1; i<=number ; i++){
            String seatNumber = "SN" + i;
            SeatType seatType = i<10 ? SeatType.VIP : i<30 ? SeatType.PREMIUM :SeatType.ECONOMY;
            int price = i<10 ? 1000 : i<30 ? 500 : 100;
            Seats seat = new Seats(i, seatNumber, SeatStatus.AVAILABLE, seatType,price);
            seats.add(seat);
        }
        return seats;
    }

    public static List<Seats> selectSeats(Concert concert, int numberOfSeats){
        List<Seats> selectedSeats = new ArrayList<>();
        List<Seats> availableSeats = concert.getSeatsList().stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .limit(numberOfSeats)
                .toList();
        selectedSeats.addAll(availableSeats);
        return selectedSeats;
    }
}
