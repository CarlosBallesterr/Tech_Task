package Controller;

import Models.CustomerResult.CustomerResult;
import Serializer.DataSerializer;

import java.io.IOException;

/**
 * The class provides functionality to deserialize {@link CustomerResult} objects into JSON and XML formats
 */
public class ReadRentalCustomer {


    /**
     * Reads and deserializes a {@link CustomerResult} object from a JSON file.
     *
     * @param path the file path to the JSON file
     * @return a {@link CustomerResult} object
     */
    public CustomerResult readDataJsonFormat(String path) throws IOException {
        try {
            DataSerializer<CustomerResult> jsonSerializer =
                    SerializerFactory.getJsonSerializer(CustomerResult.class);
            return jsonSerializer.read(path);
        } catch (IOException e) {
            throw new IOException("Error reading JSON", e);
        }
    }

    /**
     * Reads and deserializes a {@link CustomerResult} object from a XML file.
     *
     * @param path the file path to the XML file
     * @return a {@link CustomerResult} object
     */
    public CustomerResult readDataXmlFormat(String path) throws IOException {
        try {
            DataSerializer<CustomerResult> xmlSerializer =
                    SerializerFactory.getXmlSerializer(CustomerResult.class);
            return xmlSerializer.read(path);
        } catch (IOException e) {
            throw new IOException("Error reading XML", e);
        }

    }
}