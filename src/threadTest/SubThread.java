package threadTest;

public class SubThread implements  Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.println("서브스레드:" + i);
                Thread.sleep(1000); //1초
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
