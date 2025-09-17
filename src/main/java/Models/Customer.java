package Models;

import java.util.Vector;

/**
 * This class is a model of a Customer
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>(); //List similar to ArrayList

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public Vector<Rental> get_rentals() {
        return _rentals;
    }
}
