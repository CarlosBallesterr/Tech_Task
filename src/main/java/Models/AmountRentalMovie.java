package Models;

public class AmountRentalMovie {
    private String movieName;
    private double amountMovie;

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
        return "movieName='" + movieName + '\'' +
                ", amountMovie=" + amountMovie;
    }
}
