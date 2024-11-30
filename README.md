The provided **Movie Ticket Booking System** code is a modular Java program designed to simulate the functionality of an online movie ticket booking platform. Here's an overview of its key components and functionality:
**1. Classes and Responsibilities**
1. **Customer and CustomerList**:
   - **`Customer`**: Represents individual users with attributes such as name, phone number, and balance.
   - **`CustomerList`**: Manages a collection of customers. It supports operations like loading customer data from a file, adding new customers, and updating balances.
2. **Movie and MovieList**:
   - **`Movie`**: Represents a movie with details like title, language, date, seat availability, and ticket cost.
   - **`MovieList`**: Maintains a list of movies. It supports operations like loading movies from a file, searching for movies, and updating seat availability.
3. **Payment and SimplePayment**:
   - **`Payment`**: An interface defining the method `makePayment`, allowing flexibility in payment implementations.
   - **`SimplePayment`**: Implements `Payment` for straightforward balance deduction during ticket purchase.
4. **Booking**:
   - Represents a ticket booking transaction. Links a customer to a movie and tracks the number of seats booked and total cost.
5. **Main**:
   - Acts as the entry point of the program. It handles user interactions such as searching for movies, registering customers, booking tickets, and processing payments.

**2. Workflow**
1. **Movie Search**:
   - Users input the movie title, language, and date.
   - The system searches for the movie in `movies.txt`.
2. **Customer Registration and Validation**:
   - The system checks if the user is registered by searching in `customers.txt`.
   - If not registered, the user is prompted to provide details like name, phone number, and initial balance.
3. **Seat Selection and Availability**:
   - Users specify the number of seats they want to book.
   - The system verifies seat availability for the selected movie.
4. **Payment Processing**:
   - The system calculates the total cost and deducts the amount from the user's balance using the `SimplePayment` class.
5. **Booking Confirmation**:
   - If the transaction is successful, the system updates the seat availability in `movies.txt` and the user's balance in `customers.txt`.
6. **Loop for Additional Bookings**:
   - After completing a transaction, the user can opt to make another booking or exit.


**3. Key Features**
- **File-Based Storage**:
  - **`movies.txt`**: Stores movie details like title, language, show date, seat availability, and cost.
  - **`customers.txt`**: Stores customer information such as name, phone number, and balance.
- **Real-Time Updates**:
  - Seat availability and user balances are updated after each successful booking.
- **Object-Oriented Design**:
  - The program utilizes classes, interfaces, inheritance, and composition to ensure modularity and reusability.
- **Error Handling**:
  - Handles file reading/writing errors and validates user input to ensure robustness.

**4. Example Interaction**
1. User searches for "Avengers: Endgame" (English, 2023-12-31).
2. System finds the movie and shows available seats.
3. User requests to book 2 seats.
4. System checks user registration, prompts for registration if not found, and processes payment.
5. Seats are booked, files are updated, and the user receives a confirmation.
