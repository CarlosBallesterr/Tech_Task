package Controller;

import Models.CustomerResult.CustomerResult;
import Serializer.DataSerializer;

import java.io.IOException;

/**
 * The class provides functionality to serialize {@link CustomerResult} objects into JSON and XML formats
 */
public class SaveRentalCustomer {


    /**
     * Serializes the given {@link CustomerResult} object into JSON format
     *
     * @param customerResult the {@link CustomerResult} object to be serialized and saved
     */
    public void saveDataJsonFormat(CustomerResult customerResult) {
        try {
            DataSerializer<CustomerResult> jsonSerializer =
                    SerializerFactory.getJsonSerializer(CustomerResult.class);
            jsonSerializer.write(customerResult, "src/main/resources/" + customerResult.getName() + ".json");
        } catch (IOException e) {
            System.err.println("Error saving JSON data for " + customerResult.getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Serializes the given {@link CustomerResult} object into XML format
     *
     * @param customerResult the {@link CustomerResult} object to be serialized and saved
     */
    public void saveDataXmlFormat(CustomerResult customerResult) {
        try {
            DataSerializer<CustomerResult> xmlSerializer =
                    SerializerFactory.getXmlSerializer(CustomerResult.class);
            xmlSerializer.write(customerResult, "src/main/resources/" + customerResult.getName() + ".xml");
        } catch (IOException e) {
            System.err.println("Error saving XML data for " + customerResult.getName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
