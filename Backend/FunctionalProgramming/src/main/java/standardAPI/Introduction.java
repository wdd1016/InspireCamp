package standardAPI;

// 표준 API의 함수적 인터페이스
//
// @FunctionalInterface
// public interface Runnable {
//     /**
//      * When an object implementing interface <code>Runnable</code> is used
//      * to create a thread, starting the thread causes the object's
//      * <code>run</code> method to be called in that separately executing
//      * thread.
//      * <p>
//      * The general contract of the method <code>run</code> is that it may
//      * take any action whatsoever.
//      *
//      * @see     java.lang.Thread#run()
//      */
//     public abstract void run();
// }

public class Introduction {
    public static void main(String[] args) {
        // 구현 클래스 정의 후 인스턴스를 생성해서 실행
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    System.out.println("#1 : " + i);
            }
        }
        Runnable runner1 = new MyRunnable();

        // 익명 이너 클래스
        Runnable runner2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++)
                    System.out.println("#2 : " + i);
            }
        };

        // 람다식으로 run() 메서드를 정의하고 실행 가능
        Runnable runner3 = () -> {
            for (int i = 0; i < 10; i++)
                System.out.println("#3 : " + i);
        };

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);
        Thread thread3 = new Thread(runner3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
