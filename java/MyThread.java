
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            if (i == 2) {
                // Pause the current thread and allow other threads to execute
                Thread.yield();
            }
        }
    }
}

class YieldExample {
    public static void main(String[] args) {
        Thread t1 = new MyThread("Thread 1");
        Thread t2 = new MyThread("Thread 2");
        
        // Start both threads
        t1.start();
        t2.start();
    }
}


