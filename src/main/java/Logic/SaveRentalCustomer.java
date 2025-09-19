package Logic;

import Factory.FormatType;
import Factory.SerializerFactory;
import Models.ResultEntry;
import Serializer.DataSerializer;

import java.io.IOException;

public class SaveRentalCustomer {

    public void saveDataJsonFormat(ResultEntry resultEntry) throws IOException {
//        DataSerializer<ResultEntry> jsonSerializer =
//                SerializerFactory.getJsonSerializer(ResultEntry.class);
//        jsonSerializer.write(resultEntry, "src/main/resources/ResultEntry2.json");
    }

    public void saveDataXmlFormat(ResultEntry resultEntry) throws IOException {
        DataSerializer<ResultEntry> serializer =
                SerializerFactory.getSerializer(FormatType.XML, ResultEntry.class, ResultEntry.class);
        serializer.write(resultEntry, "src/main/resources/ResultEntry2.xml");

//        DataSerializer<ResultEntry> xmlSerializer =
//                SerializerFactory.getXmlSerializer(ResultEntry.class);
//        xmlSerializer.write(resultEntry, "src/main/resources/ResultEntry2.xml");
    }


}
