package Models;

import java.util.Vector;

/**
 * This class is a model of a Customer
 */
public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();
    private String _lastName;
    private int _age;
    private String _gender;

    protected  Customer(CustomerBuild build) {
        _name = build.get_name();
        _lastName = build.get_lastName();
        _age = build.get_age();
        _gender = build.get_gender();
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public Vector<Rental> get_rentals() {
        return _rentals;
    }

    public String get_name() {
        return _name;
    }

    public String get_lastName() {
        return _lastName;
    }

    public int get_age() {
        return _age;
    }

    public String get_gender() {
        return _gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "_name='" + _name + '\'' +
                ", _lastName='" + _lastName + '\'' +
                ", _age=" + _age +
                ", _gender='" + _gender + '\'' +
                ", _rentals=" + _rentals +
                '}';
    }
}
