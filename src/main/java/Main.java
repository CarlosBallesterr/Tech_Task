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

//        DataSerializer<ResultEntry> xmlSerializer2 =
//                SerializerFactory.getXmlSerializer(ResultEntry.class);
//
//        ResultEntry wrapper2 = xmlSerializer2.read("src/main/resources/ResultEntry.xml");
//
//        System.out.println(wrapper2);
    }
}
