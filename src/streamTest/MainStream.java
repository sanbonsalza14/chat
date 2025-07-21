package streamTest;

import java.io.InputStream;


public class MainStream {
    public static void main(String[] args) {
        //1바이트 씩 밖에는 전송이 안됨.
        InputStream in =System.in;  //키보드 입력(byte Stream)
        try {
            //1. 키보드에서 A를 인코딩 010000dmfh zjavbxj wjsthd
            //2. byteStream 를 통해서 input
            //3. read() 잃어욧.... 010000 -> 65 변환
            //4. 65숫자를 부호화 (디코딩) -> 출력
            int data = in.read();
            System.out.println((char) data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
