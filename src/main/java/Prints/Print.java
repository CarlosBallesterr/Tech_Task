package Prints;


import Models.Rental;

/**
 * This class prints the messages
 */
public class Print {

    public String header(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }

    public String rentalLine(Rental each, double amount) {
        return "\t" + each.getMovie().getTitle() + "\t" + amount + "\n";
    }

    public String footer(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points";
    }

}
