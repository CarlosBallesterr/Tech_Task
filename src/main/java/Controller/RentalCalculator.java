package Controller;


import Models.*;
import Models.CustomerResult.AmountRentalMovie;
import Models.CustomerResult.CustomerResult;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * This class calculates the customer's account balance for their rentals.
 */
public class RentalCalculator {

    private Customer customer;
    private SaveRentalCustomer saveRentalCustomer;

    public RentalCalculator(Customer customer) {
        this.customer = customer;
        this.saveRentalCustomer = new SaveRentalCustomer();
    }

    /**
     * Calculate the customer's account balance for their rentals.
     *
     * @return a string with the customer's account balance, ready to be printed or displayed
     */

    public CustomerResult calculate() {
        CustomerResult customerResult = initResultEntry();
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        List<AmountRentalMovie> listResult = new ArrayList<>();

        try {
            Enumeration<Rental> rentals = customer.get_rentals().elements();
            while (rentals.hasMoreElements()) {
                Rental rental = rentals.nextElement();

                double thisAmount = calculateAmount(rental);
                frequentRenterPoints = calculateRenterPoints(rental, frequentRenterPoints);

                listResult.add(buildAmountRentalMovie(rental, thisAmount));
                totalAmount += thisAmount;
            }

            updateResultEntry(customerResult, listResult, totalAmount, frequentRenterPoints);

            saveRentalCustomer.saveDataJsonFormat(customerResult);

        } catch (Exception e) {
            System.err.println("Error during rental calculation: " + e.getMessage());
            e.printStackTrace();
        }

        return customerResult;
    }

    /**
     * Initializes a {@link CustomerResult} object with the customer's basic information
     *
     * @return a new {@link CustomerResult} containing the customer's full name
     */
    private CustomerResult initResultEntry() {
        CustomerResult customerResult = new CustomerResult();
        customerResult.setName(customer.get_name() + " " + customer.get_lastName());
        return customerResult;
    }


    /**
     * Builds an {@link AmountRentalMovie} object with the movie title and the calculated real amount
     *
     * @param rental the {@link Rental} object containing the movie
     * @param amount the calculated amount for the rental
     * @return a nwe {@link AmountRentalMovie} with the movie title and amount
     */
    private AmountRentalMovie buildAmountRentalMovie(Rental rental, double amount) {
        return new AmountRentalMovie(rental.getMovie().getTitle(), amount);
    }

    /**
     * Updates a {@link CustomerResult} object with the final rental calculation data:
     * the list of movies, the total amount owed, and the frequent renter points.
     *
     * @param entry the {@link CustomerResult} to update
     * @param list the list of movies with their respective rental amounts
     * @param totalAmount the total amount owed by the customer
     * @param points the frequent renter points earned by the customer
     */
    private void updateResultEntry(CustomerResult entry, List<AmountRentalMovie> list, double totalAmount, int points) {
        entry.setMovies(list);
        entry.setAmountOwed(totalAmount);
        entry.setFrequentRenterPoints(points);
    }

    /**
     * Calculates the amount to be paid for renting a movie,
     * based on the type of movie and the number of days rented.
     *
     * @param each the {@link Rental} object containing the movie and the days rented
     * @return the total amount calculated for that rental
     */
    private double calculateAmount(Rental each) {
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
                default:
                    System.err.println("Unknown movie type for: " + each.getMovie().getTitle());
            }
        } catch (NullPointerException e) {
            System.err.println("Error calculating amount for rental: " + e.getMessage());
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
    private int calculateRenterPoints(Rental each, int frequentRenterPoints) {
        try {
            int priceCode = each.getMovie().getPriceCode();
            if (priceCode == MovieTypes.NEW_RELEASE || priceCode == MovieTypes.CHILDREN) {
                frequentRenterPoints++;
            }

            if (priceCode == MovieTypes.NEW_RELEASE && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
        } catch (NullPointerException e) {
            System.err.println("Error calculating renter points: " + e.getMessage());
        }
        return frequentRenterPoints;
    }

}