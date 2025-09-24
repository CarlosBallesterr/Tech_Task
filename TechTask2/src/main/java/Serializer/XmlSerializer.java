package Serializer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;

/**
 * A generic XML serializer and deserializer using Jakarta XML Binding (JAXB).
 */
public class XmlSerializer<T> extends DataSerializer<T> {
    private final Class<T> _tClass;

    public XmlSerializer(Class<T> tClass) {
        this._tClass = tClass;
    }

    @Override
    public T read(String filePath) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(_tClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(filePath));
        } catch (Exception e) {
            throw new IOException("Error reading XML", e);
        }
    }

    @Override
    public void write(T data, String filePath) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(_tClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(data, new File(filePath));
        } catch (Exception e) {
            throw new IOException("Error writing XML", e);
        }
    }

}
