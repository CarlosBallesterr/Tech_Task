import Factory.FormatType;
import Factory.SerializerFactory;
import Logic.RentalCalculator;
import Models.*;
import Serializer.DataSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // JSON para lista de MovieTypeEntry
        Type movieListType = new TypeToken<List<MovieTypeEntry>>() {}.getType();
        DataSerializer<List<MovieTypeEntry>> jsonSerializer =
                SerializerFactory.getJsonSerializer(movieListType);

        List<MovieTypeEntry> movieTypes = jsonSerializer.read("src/main/resources/MovieTypeEntry.JSON");

        for (MovieTypeEntry movieTypeEntry : movieTypes) {
            //System.out.println(movieTypeEntry);
        }

        Type resultListType = new TypeToken<List<ResultEntry>>() {}.getType();
        DataSerializer<List<ResultEntry>> jsonSerializer2 =
                SerializerFactory.getJsonSerializer(resultListType);

        List<ResultEntry> resultTypes = jsonSerializer2.read("src/main/resources/ResultEntry.JSON");

        for (ResultEntry resultTypeEntry : resultTypes) {
            System.out.println(resultTypeEntry);
        }

        //jsonSerializer.write(movieTypes, "src/main/resources/movieTypes_out.json");

        /*
        // XML para ResultEntry
        DataSerializer<ResultEntry> xmlSerializer =
                SerializerFactory.getXmlSerializer(ResultEntry.class);

        ResultEntry result = xmlSerializer.read("result.xml");
        xmlSerializer.write(result, "result_out.xml");
         */
    }
}
