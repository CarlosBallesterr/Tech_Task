package Logic;


import Models.*;
import Prints.Print;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * This class calculates the customer's account balance for their rentals.
 */
public class RentalCalculator {

    private Customer customer;
    private final Print print;
    private SaveRentalCustomer saveRentalCustomer;

    public RentalCalculator(Customer customer) {
        this.customer = customer;
        this.print = new Print();
        this.saveRentalCustomer = new SaveRentalCustomer();
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
    public String calculate() throws IOException {

        ResultEntry resultEntry =  new ResultEntry();//for result

        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration<Rental> rentals = customer.get_rentals().elements();
        StringBuilder result = new StringBuilder(print.header(customer.get_name()));

        resultEntry.setName(customer.get_name() +" "+customer.get_lastName());//for result
        List<AmountRentalMovie> listResult = new ArrayList<>();//for result

        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            double thisAmount = calculateAmount(each);
            frequentRenterPoints = calculateRenterPoints(each, frequentRenterPoints);
            result.append(print.rentalLine(each, thisAmount));

            AmountRentalMovie amountRentalMovie = new AmountRentalMovie(each.getMovie().getTitle(), thisAmount);//for result
            listResult.add(amountRentalMovie);//for result


            totalAmount += thisAmount;
        }
        resultEntry.setMovies(listResult);//for result

        result.append(print.footer(totalAmount, frequentRenterPoints));

        resultEntry.setAmountOwed(totalAmount);//for result
        resultEntry.setFrequentRenterPoints(frequentRenterPoints);//for result

        saveRentalCustomer.saveDataXmlFormat(resultEntry);

        return result.toString();
    }
}