package streamTest;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderTest {
    public static void main(String[] args) {
//        InputStream in = System.in;
//        InputStreamReader ir = new InputStreamReader(in);
//        BufferedReader br = new BufferedReader(ir);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String data = br.readLine();
            System.out.println(data);
        } catch (IOException e) {
            throw new RuntimeException(e);

        }

    }
}
