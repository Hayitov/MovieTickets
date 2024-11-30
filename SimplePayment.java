// SimplePayment.java
public class SimplePayment implements Payment {
    private Customer customer;

    public SimplePayment(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean makePayment(double amount) {
        if (customer.getBalance() >= amount) {
            customer.deductBalance(amount);
            // Balance will be updated in the CustomerList
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}
