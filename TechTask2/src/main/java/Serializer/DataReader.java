package Serializer;

import java.io.IOException;

/**
 * A generic interface for reading data from a file.
 */
public interface DataReader<T> {
    T read(String filePath) throws IOException;
}
