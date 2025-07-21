package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    //클라이언트로부터 연결을 받는 소켓
    ServerSocket serverSocket;
    //실제 통신을 하는 소켓
    Socket socket;
    BufferedReader br; //클라이언트가 보낸 글을 받는 용도
    BufferedReader keyboard; //키보드로부터 입력
    BufferedWriter bw; //클라이언트 소켓에 보내는 용도

    public ServerSide() {
        System.out.println("1.서버소켓 시작");
        try {
            serverSocket = new ServerSocket(10000);
            System.out.println("2.서버소켓 생성완료");
            socket = serverSocket.accept();
            System.out.println("3.클라리언트 접속완료");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //ㅋ;보드 생성
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            //소켓 전송 버퍼 생성
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //클라이언트로 메시지 보내는 스레드 생성 후 실행
            WriteThread wt = new WriteThread();
            Thread t1 = new Thread(wt);
            t1.start();

            while (true) {
                String msg = br.readLine();
                System.out.println("4,클라이언트가 보낸 메시지 : " + msg);
            }
        } catch (Exception e) {
            System.out.println("서버소켓 오류:"+ e.getMessage());
        }

    }

    //내부 클래스로 메세지 보내는 기능 만들기
    class WriteThread implements Runnable {

        @Override
        public void run() {
            //클라이언트에 메시지 보내는 기능
            while (true) {
                try {
                    String keyboardMsg = keyboard.readLine();
                    bw.write(keyboard+"\n");
                    bw.flush();

                } catch (Exception e) {
                    System.out.println("서버 쪽 키보드 입력 오류:" + e.getMessage());
                }
            }

        }
    }
    public static void main(String[] args) {
        new ServerSide();
    }
}





