package Models.CustomerResult;

import jakarta.xml.bind.annotation.*;
import java.util.List;


/**
 * This class is a model of a result Customer
 */
@XmlRootElement(name = "ResultEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerResult {
    private String name;

    @XmlElementWrapper(name = "movies")
    @XmlElement(name = "movie")
    private List<AmountRentalMovie> movies;

    private double amountOwed;
    private int frequentRenterPoints;

    public CustomerResult() {}

    public CustomerResult(String name, List<AmountRentalMovie> movies, double amountOwed, int frequentRenterPoints) {
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

    public List<AmountRentalMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<AmountRentalMovie> movies) {
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
        return "Rental Record for: " + name +
                ", \n" + movies +
                ", \nAmount owed is: " + amountOwed +
                ", \nYou earned " + frequentRenterPoints + " frequent renter points";
    }
}