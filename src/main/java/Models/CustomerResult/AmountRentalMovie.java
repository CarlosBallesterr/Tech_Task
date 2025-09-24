package Models.CustomerResult;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;

/**
 * This class is a model for list of amount rental  movies
 */
@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class AmountRentalMovie {
    private String movieName;
    private double amountMovie;

    public AmountRentalMovie() {}

    public AmountRentalMovie(String movieName, double amountMovie) {
        this.movieName = movieName;
        this.amountMovie = amountMovie;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getAmountMovie() {
        return amountMovie;
    }

    public void setAmountMovie(double amountMovie) {
        this.amountMovie = amountMovie;
    }

    @Override
    public String toString() {
        return "  " +movieName + " " + amountMovie + "\n";
    }
}
