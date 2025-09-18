package Models;

import java.util.Vector;

public class CustomerBuild {
    // Required parameters
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    // Optional parameters
    private String _lastName;
    private int _age;
    private String _gender;

    public CustomerBuild(String _name) {
        this._name = _name;
    }

    public CustomerBuild addRental(Rental rental) {
        this._rentals.add(rental);
        return this;
    }

    public CustomerBuild addLastName(String lastName) {
        this._lastName = lastName;
        return this;
    }

    public CustomerBuild addAge(int age) {
        this._age = age;
        return this;
    }

    public CustomerBuild addGender(String gender) {
        this._gender = gender;
        return this;
    }

    // Build method to create a Customer object
    public Customer build() {
        Customer customer = new Customer(this);
        for (Rental rental : _rentals) {
            customer.addRental(rental);
        }
        return customer;
    }

    @Override
    public String toString() {
        return "CustomerBuild{" +
                "_name='" + _name + '\'' +
                ", _lastName='" + _lastName + '\'' +
                ", _age=" + _age +
                ", _gender='" + _gender + '\'' +
                ", _rentals=" + _rentals +
                '}';
    }

    public String get_name() {
        return _name;
    }

    public Vector<Rental> get_rentals() {
        return _rentals;
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
}
