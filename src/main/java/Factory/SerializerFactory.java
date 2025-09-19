package Factory;

import Serializer.DataSerializer;
import Serializer.JsonSerializer;
import Serializer.XmlSerializer;

import java.lang.reflect.Type;

public class SerializerFactory {


    public static <T> DataSerializer<T> getSerializer(FormatType format, Type type, Class<T> clazz) {
        switch (format) {
            case JSON:
                return new JsonSerializer<>(type);
            case XML:
                return new XmlSerializer<>(clazz);
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }


//    public static <T> DataSerializer<T> getJsonSerializer(Type type) {
//        return new JsonSerializer<>(type);
//    }
//
//    public static <T> DataSerializer<T> getXmlSerializer(Class<T> clazz) {
//        return new XmlSerializer<>(clazz);
//    }
}
