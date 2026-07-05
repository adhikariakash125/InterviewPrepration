package LLD.ConcertTicketBooking.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Concert {
    private String id;
    private String name;
    private String artistName;
    private List<Seats> seatsList;
    private LocalDateTime date;
    private String venue;

    public Concert(String id, String name, String artistName, List<Seats> seatsList, LocalDateTime date, String venue) {
        this.id = id;
        this.name = name;
        this.artistName = artistName;
        this.seatsList = seatsList;
        this.date = date;
        this.venue = venue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public List<Seats> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seats> seatsList) {
        this.seatsList = seatsList;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
