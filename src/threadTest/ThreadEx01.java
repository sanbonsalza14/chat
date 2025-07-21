package threadTest;

public class ThreadEx01 {
    public static void main(String[] args) {
        SubThread st = new SubThread();
        Thread thread = new Thread(st);

        thread.start();  //run()이 실행
         for (int i = 1; i <= 10; i++) {
            try {
                System.out.println("메인스레드:" + i);
                Thread.sleep(1000); //1초
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
