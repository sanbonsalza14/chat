package streamTest;

import java.io.InputStream;
import java.io.InputStreamReader;

public class inputStreamReaderTest {
    public static void main(String[] args) {
        InputStream in = System.in;
        InputStreamReader ir = new InputStreamReader(in);
        try {
            char[]data = new char[100];
            ir.read(data); //읽어온 바이트를 배열에 저장
            System.out.println(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
