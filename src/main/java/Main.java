import Factory.FormatType;
import Factory.SerializerFactory;
import Logic.LoadMovieTypes;
import Logic.RentalCalculator;
import Models.*;
import Serializer.DataSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Carlos");
        customer.addRental(new Rental(new Movie("Zack Snyder's Justice League", 1), 5));
        customer.addRental(new Rental(new Movie("Terminator", 0), 1));
        customer.addRental(new Rental(new Movie("Soul", 2), 3));

        RentalCalculator rentalCalculator = new RentalCalculator(customer);
        System.out.println(rentalCalculator.calculate());
    }
}
