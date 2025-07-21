package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientSide {
    Socket socket;
    BufferedReader keyboard;  // 키보드에서 입력 받는 용도
    BufferedWriter bw; // 서버에 내용을 전송할 용도
    BufferedReader br; // 서버가 보낸 메시지 읽기

    // 소켓 연결하기
    public ClientSide() {
        try {
            System.out.println("1. 클라이언트 소켓 시작");
            socket = new Socket("127.0.0.1", 10000);
            // 서버에다 전송
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 키보드에서 입력 받기
            keyboard = new BufferedReader(new InputStreamReader(System.in));

            // 서버에서 보낸 메시지 소켓에서 읽기
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // 서버메시지 받는 스레드 시작하기
            ReadThread readThread = new ReadThread();
            Thread t1 = new Thread(readThread);
            t1.start();

            while (true) {
                System.out.println("2. 키보드 메시지 입력 대기 중");
                String keyboardMsg = keyboard.readLine();
                // 메시지 끝을 항상 포함(리턴문자)
                bw.write(keyboardMsg + "\n");
                bw.flush();  // 서버에 전송
            }

        } catch (Exception e) {
            System.out.println("클라이언트 소켓 에러 : " + e.getMessage() );
        }
    }

    class ReadThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    String msg = br.readLine();
                    System.out.println(">> 서버메시지 : " + msg);
                } catch (Exception e) {
                    System.out.println("서버 메시지 받는 중 오류 : " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new ClientSide();
    }
}
