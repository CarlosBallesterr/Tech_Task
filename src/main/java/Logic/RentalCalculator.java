package Logic;


import Models.*;
import Prints.Print;

import java.util.Enumeration;

/**
 * This class calculates the customer's account balance for their rentals.
 */
public class RentalCalculator {

    private Customer customer;
    private final Print print;

    public RentalCalculator(Customer customer) {
        this.customer = customer;
        this.print = new Print();
    }

    /**
     * Calculates the amount to be paid for renting a movie,
     * based on the type of movie and the number of days rented.
     *
     * @param each the {@link Rental} object containing the movie and the days rented
     * @return the total amount calculated for that rental
     */
    private double calculateAmount(Rental each){
        double thisAmount = 0;
        try {
            switch (each.getMovie().getPriceCode()) {
                case MovieTypes.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case MovieTypes.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case MovieTypes.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }
        } catch (NullPointerException e) {
            System.out.println("No se calculo el monto.");
        }

        return thisAmount;
    }


    /**
     * Calculates the frequency points for rented movies.
     *
     * @param each the {@link Rental} object containing the movie and price code
     * @param frequentRenterPoints is the value received with the current frequency points
     * @return the frequency points for rented movies
     */
    private int calculateRenterPoints(Rental each, int frequentRenterPoints){
        try {
            if (each.getMovie().getPriceCode() == MovieTypes.NEW_RELEASE || each.getMovie().getPriceCode() == MovieTypes.CHILDREN) {
                frequentRenterPoints++;
            }

            if (each.getMovie().getPriceCode() == MovieTypes.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        } catch (NullPointerException e) {
            System.out.println("no se pudo calcular los puntos de rentas.");
        }
        return frequentRenterPoints;
    }

    /**
     * Calculate the customer's account balance for their rentals.
     *
     * @return a string with the customer's account balance, ready to be printed or displayed
     */
    public String calculate() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = customer.get_rentals().elements();
        StringBuilder result = new StringBuilder(print.header(customer.getName()));
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            double thisAmount = calculateAmount(each);
            frequentRenterPoints = calculateRenterPoints(each, frequentRenterPoints);
            result.append(print.rentalLine(each, thisAmount));
            totalAmount += thisAmount;
        }
        result.append(print.footer(totalAmount, frequentRenterPoints));
        return result.toString();
    }
}