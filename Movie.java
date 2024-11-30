// Movie.java
public class Movie {
    private String title;
    private String language;
    private String date;
    private int totalSeats;
    private int availableSeats;
    private double cost;

    public Movie(String title, String language, String date, int totalSeats, int availableSeats, double cost) {
        this.title = title;
        this.language = language;
        this.date = date;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
        this.cost = cost;
    }

    // Getters and setters
    public String getTitle() { return title; }
    public String getLanguage() { return language; }
    public String getDate() { return date; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }
    public double getCost() { return cost; }

    public void bookSeats(int numberOfSeats) {
        availableSeats -= numberOfSeats;
    }
}
