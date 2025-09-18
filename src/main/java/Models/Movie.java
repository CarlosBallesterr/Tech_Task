package Models;

/**
 * This class is a model of a movie
 */
public class Movie {
    private final String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int arg) {
        _priceCode = arg;
    }

    public String getTitle() {
        return _title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "_title='" + _title + '\'' +
                ", _priceCode=" + _priceCode +
                '}';
    }
}
