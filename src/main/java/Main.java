import Factory.SerializerFactory;
import Logic.RentalCalculator;
import Models.*;
import Serializer.DataSerializer;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Customer customer = new CustomerBuild("Carlos").addLastName("Ballester").addGender("Make").addAge(23).build();
        customer.addRental(new Rental(new Movie("Zack Snyder's Justice League", 1), 5));
        customer.addRental(new Rental(new Movie("Terminator", 0), 1));
        customer.addRental(new Rental(new Movie("Soul", 2), 3));

        RentalCalculator rentalCalculator = new RentalCalculator(customer);
        System.out.println(rentalCalculator.calculate());

//        DataSerializer<MovieTypeEntryList> xmlSerializer =
//                SerializerFactory.getXmlSerializer(MovieTypeEntryList.class);
//
//        MovieTypeEntryList wrapper = xmlSerializer.read("src/main/resources/MovieTypeEntry.xml");
//
//
//        for (MovieTypeEntry entry : wrapper.getMovieTypes()) {
//            System.out.println(entry);
//        }
    }
}
