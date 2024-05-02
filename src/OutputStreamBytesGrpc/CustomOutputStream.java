package OutputStreamBytesGrpc;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CustomOutputStream extends OutputStream {

    private final StreamObserver<DataChunk> streamObserver;
    private final Integer MAX_CHUNK_SIZE = 32;
    // Buffer to store bytes before sending them in chunks
    private byte[] buffer;
    // Current position in the buffer
    private int position;

    public CustomOutputStream(StreamObserver<DataChunk> streamObserver)
    {
        this.streamObserver = streamObserver;
        buffer = new byte[MAX_CHUNK_SIZE];
        position = 0;
    }
    @Override
    public void write(int b) throws IOException
    {
        // Write the byte to the buffer
        buffer[position++] = (byte) b;
        // Flush the buffer if it is full
        if(position == MAX_CHUNK_SIZE)
        {
            flushBuffer();
        }
    }

    public void write(byte[] b) throws IOException
    {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int off, int len) throws IOException
    {
        // Calculate remaining bytes to write
        int remaining = len;
        // Initialize offset to start position in the byte array
        int offset = off;

        while(remaining > 0)
        {
            // Determine chunk size (minimum of remaining bytes and MAX_CHUNK_SIZE)
            int chunkSize = Math.min(remaining, MAX_CHUNK_SIZE);
            // Copy chunk of bytes from input array to a new array
            byte[] chunkData = Arrays.copyOfRange(b, offset, offset + chunkSize);

            // Create DataChunk object with the chunk data and send it
            DataChunk dataChunk = new DataChunk(chunkData);

            streamObserver.onNext(dataChunk);
            // Update offset and remaining bytes
            len = len - remaining;
            offset = offset + chunkSize;
        }
    }

    public void close() throws IOException {
        // Flush any remaining data and complete the stream observer
        flush();
        streamObserver.onCompleted();
    }
    public void flush() throws IOException {
        // Flush the buffer if it contains any data
        if(position > 0)
            flushBuffer();
    }

    public void flushBuffer() throws IOException {
        // Create a DataChunk object with the buffer contents and send it
        DataChunk chunk = new DataChunk(Arrays.copyOf(buffer, position));
        streamObserver.onNext(chunk);
        // Reset the position to prepare for the next chunk
        position = 0;
    }
}
