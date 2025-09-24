package Serializer;

import java.io.IOException;

/**
 * A generic interface for writing data to a file.
 */
public interface DataWriter<T> {
    void write(T data, String filePath) throws IOException;
}
