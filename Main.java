// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();
        CustomerList customerList = new CustomerList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Movie Ticket Booking System");

        while (true) {
            System.out.println("Enter movie title:");
            String title = scanner.nextLine();

            System.out.println("Enter movie language:");
            String language = scanner.nextLine();

            System.out.println("Enter date (e.g., 2023-12-31):");
            String date = scanner.nextLine();

            Movie movie = movieList.findMovie(title, language, date);
            if (movie == null) {
                System.out.println("Movie not found. Do you want to search again? (yes/no)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("no")) {
                    System.out.println("Exiting...");
                    break;
                } else {
                    continue;
                }
            }

            System.out.println("Enter number of seats:");
            int numberOfSeats = Integer.parseInt(scanner.nextLine());

            if (movie.getAvailableSeats() < numberOfSeats) {
                System.out.println("Not enough seats available.");
                continue;
            }

            System.out.println("Enter your name:");
            String name = scanner.nextLine();

            Customer customer = customerList.findCustomerByName(name);
            if (customer == null) {
                System.out.println("Customer not found. Please register.");

                System.out.println("Enter your phone number:");
                String phoneNumber = scanner.nextLine();

                System.out.println("Enter initial balance:");
                double balance = Double.parseDouble(scanner.nextLine());

                customer = new Customer(name, phoneNumber, balance);
                customerList.addCustomer(customer);
            }

            Booking booking = new Booking(customer, movie, numberOfSeats);
            Payment payment = new SimplePayment(customer);

            if (booking.processPayment(payment)) {
                movie.bookSeats(numberOfSeats);
                movieList.updateMovie(movie);
                customerList.updateCustomerBalance(customer);

                System.out.println("Booking successful!");
                System.out.println("Total cost: " + booking.getTotalCost());
            } else {
                System.out.println("Payment failed.");
            }

            System.out.println("Do you want to make another booking? (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                System.out.println("Thank you for using the Movie Ticket Booking System.");
                break;
            }
        }

        scanner.close();
    }
}
