// CustomerList.java
import java.util.*;
import java.io.*;

public class CustomerList {
    private List<Customer> customers;

    public CustomerList() {
        customers = new ArrayList<>();
        loadCustomersFromFile();
    }

    private void loadCustomersFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("customers.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                // Format: name,phoneNumber,balance
                String[] parts = line.split(",");
                String name = parts[0];
                String phoneNumber = parts[1];
                double balance = Double.parseDouble(parts[2]);
                customers.add(new Customer(name, phoneNumber, balance));
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading customers file.");
            e.printStackTrace();
        }
    }

    public Customer findCustomerByName(String name) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        saveCustomersToFile();
    }

    public void updateCustomerBalance(Customer customer) {
        saveCustomersToFile();
    }

    private void saveCustomersToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("customers.txt"));
            for (Customer c : customers) {
                bw.write(c.getName() + "," + c.getPhoneNumber() + "," + c.getBalance());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing customers file.");
            e.printStackTrace();
        }
    }
}
