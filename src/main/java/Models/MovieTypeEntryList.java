package Models;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "MovieTypes")
public class MovieTypeEntryList {

    private List<MovieTypeEntry> movieTypes;

    @XmlElement(name = "movieTypeEntry")
    public List<MovieTypeEntry> getMovieTypes() {
        return movieTypes;
    }

    public void setMovieTypes(List<MovieTypeEntry> movieTypes) {
        this.movieTypes = movieTypes;
    }
}
