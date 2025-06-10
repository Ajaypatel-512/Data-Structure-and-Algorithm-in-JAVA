package Extra.MultiThreading;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();

        MyThread2 t2 = new MyThread2();
        Thread thread2 = new Thread(t2);
        thread2.start();
    }
}
