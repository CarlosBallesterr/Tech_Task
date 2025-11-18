package Serializer;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * A generic JSON serializer and deserializer using the Gson library.
 */
public class JsonSerializer<T> extends DataSerializer<T> {
    private final Gson gson = new Gson();
    private final Type type;

    public JsonSerializer(Type type) {
        this.type = type;
    }

    @Override
    public T read(String filePath) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            throw new IOException("Error reading JSON", e);
        }
    }

    @Override
    public void write(T data, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, type, writer);
        } catch (IOException e) {
            throw new IOException("Error writing JSON", e);
        }
    }
}
