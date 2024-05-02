package OutputStreamBytesGrpc;


import java.io.IOException;

public class DataChunk {
    private final byte[] bytes;

    public DataChunk(byte[] bytes) throws IOException {
        if(bytes.length > 32)
            throw new IOException("bytes greater than 32");
        this.bytes = bytes;
    }
}
