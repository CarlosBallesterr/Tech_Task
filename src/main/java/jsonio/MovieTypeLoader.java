package jsonio;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class MovieTypeLoader {
    public static Map<Integer, String> loadMovieTypes(String filePath) throws Exception {
        Gson gson = new Gson();
        FileReader reader = new FileReader(filePath);

        Type mapType = new TypeToken<Map<Integer, String>>() {}.getType();
        return gson.fromJson(reader, mapType);
    }
}