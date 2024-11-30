// MovieList.java
import java.util.*;
import java.io.*;

public class MovieList {
    private List<Movie> movies;

    public MovieList() {
        movies = new ArrayList<>();
        loadMoviesFromFile();
    }

    private void loadMoviesFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // Format: title,language,date,totalSeats,availableSeats,cost
                String[] parts = line.split(",");
                if (parts.length != 6) {
                    System.out.println("Invalid line in movies.txt: " + line);
                    continue; // Skip invalid lines
                }
                String title = parts[0];
                String language = parts[1];
                String date = parts[2];
                int totalSeats;
                int availableSeats;
                double cost;
                try {
                    totalSeats = Integer.parseInt(parts[3]);
                    availableSeats = Integer.parseInt(parts[4]);
                    cost = Double.parseDouble(parts[5]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                    continue; // Skip invalid lines
                }
                movies.add(new Movie(title, language, date, totalSeats, availableSeats, cost));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading movies file.");
            e.printStackTrace();
        }
    }

    // Rest of the class remains the same...
}
