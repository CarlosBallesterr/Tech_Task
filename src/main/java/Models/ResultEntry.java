package Models;

import java.util.ArrayList;
import java.util.List;

public class ResultEntry {
    private String name;
    private List<AmountRentalMovie> movies;
    private double amountOwed;
    private int frequentRenterPoints;

    public ResultEntry(String name, List<AmountRentalMovie> movies, double amountOwed, int frequentRenterPoints) {
        this.name = name;
        this.movies = movies;
        this.amountOwed = amountOwed;
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getMovies() {
        return movies;
    }

    public void setMovies(ArrayList movies) {
        this.movies = movies;
    }

    public double getAmountOwed() {
        return amountOwed;
    }

    public void setAmountOwed(double amountOwed) {
        this.amountOwed = amountOwed;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", \nmovies=" + movies +
                ", \namountOwed=" + amountOwed +
                ", \nfrequentRenterPoints=" + frequentRenterPoints;
    }
}