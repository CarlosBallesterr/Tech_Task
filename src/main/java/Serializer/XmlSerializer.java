package Serializer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> extends DataSerializer<T> {
    private final Class<T> clazz;

    public XmlSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T read(String filePath) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new File(filePath));
        } catch (Exception e) {
            throw new IOException("Error reading XML", e);
        }
    }

    @Override
    public void write(T data, String filePath) throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(data, new File(filePath));
        } catch (Exception e) {
            throw new IOException("Error writing XML", e);
        }
    }

}
