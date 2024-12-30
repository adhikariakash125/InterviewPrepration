package Java.Java8;

class Film {
    private String title;
    private String genre;
    private String description;
    private double rating;

    public Film(String title, String genre, String description, double rating) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ")";
    }
}