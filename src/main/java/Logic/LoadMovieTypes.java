package Logic;

import Factory.SerializerFactory;
import Models.MovieTypeEntry;
import Models.ResultEntry;
import Serializer.DataSerializer;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class LoadMovieTypes {

    public void loadMovieTypes() throws IOException {
        Type movieListType = new TypeToken<List<MovieTypeEntry>>() {}.getType();
        DataSerializer<List<MovieTypeEntry>> jsonSerializer =
                SerializerFactory.getJsonSerializer(movieListType);

        List<MovieTypeEntry> movieTypes = jsonSerializer.read("src/main/resources/MovieTypeEntry.JSON");

        for (MovieTypeEntry movieTypeEntry : movieTypes) {
            System.out.println(movieTypeEntry);
        }
    }
}
