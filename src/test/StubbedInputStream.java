package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

class StubbedInputStream extends InputStream {
    private final Queue<String> input;

    public StubbedInputStream(Queue<String> input) {
        this.input = input;
    }

    @Override
    public int read(byte[] bytes) throws IOException {
        return super.read(bytes);
    }

    @Override
    public int read(byte[] bytes, int i, int i1) throws IOException {
        if(input.isEmpty()) {
            return -1;
        }

        int byteLocation = 0;
        for(byte b : input.remove().getBytes()) {
            bytes[byteLocation] = b;
            byteLocation++;
        }
        bytes[byteLocation] = "\n".getBytes()[0];
        return byteLocation + 1;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    public static InputStreamBuilder stubInputStream() {
        return new InputStreamBuilder();
    }
}
