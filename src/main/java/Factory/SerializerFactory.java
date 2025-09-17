package Factory;

import Serializer.DataSerializer;
import Serializer.JsonSerializer;
import Serializer.XmlSerializer;

import java.lang.reflect.Type;

public class SerializerFactory {
    public static <T> DataSerializer<T> getJsonSerializer(Type type) {
        return new JsonSerializer<>(type);
    }

    public static <T> DataSerializer<T> getXmlSerializer(Class<T> clazz) {
        return new XmlSerializer<>(clazz);
    }
}
