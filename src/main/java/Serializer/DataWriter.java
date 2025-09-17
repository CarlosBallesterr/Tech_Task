package Serializer;

import java.io.IOException;

public interface DataWriter<T> {
    void write(T data, String filePath) throws IOException;
}
