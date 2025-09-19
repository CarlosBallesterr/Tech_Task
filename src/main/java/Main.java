import Controller.RentalCalculator;
import Models.*;
import Models.CustomerBuild;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer customer = new CustomerBuild("Carlos").addLastName("Ballester").addGender("Make").addAge(23).build();
        customer.addRental(new Rental(new Movie("Zack Snyder's Justice League", 1), 5));
        customer.addRental(new Rental(new Movie("Terminator", 0), 1));
        customer.addRental(new Rental(new Movie("Soul", 2), 3));

        RentalCalculator rentalCalculator = new RentalCalculator(customer);
        System.out.println(rentalCalculator.calculate());
    }
}
