package Serializer;

import java.io.IOException;

/**
 *
 * A generic class that implements both {@link DataReader} and {@link DataWriter}
 * interfaces to provide serialization and deserialization functionality.
 */
public class DataSerializer<T> implements DataReader<T>, DataWriter<T> {

    @Override
    public T read(String filePath) throws IOException {
        return null;
    }

    @Override
    public void write(T data, String filePath) throws IOException {

    }
}
