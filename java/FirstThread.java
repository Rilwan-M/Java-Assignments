
class FirstThread extends Thread{

    public void run(){
        for (int i=0; i<=5; i++){
        if (i==3){
            Thread.yield();
            System.out.println("From thread A i ="+i);
        }
        System.out.println("Exit thread A");
        }
        }
    }
    class SecondThread extends Thread{
    public void run(){
    for (int i=0; i<=5; i++){
    System.out.println("From thread B i ="+i);
    }
    System.out.println("Exit thread B");
    }
    }
    class ThirdThread extends Thread{
    public void run(){
    for (int i=0; i<=5; i++){
    if (i==1){
    try{
    sleep(1000);
    }
    catch(Exception e){
    System.out.println(e);
    }
    }
    }
    System.out.println("Exit thread C");
    }
    }

    class Test{
    public static void main(String args[]){
    FirstThread f = new FirstThread();
    SecondThread s = new SecondThread();
    ThirdThread t= new ThirdThread();
    System.out.println("Starting threads");
    t.start();
    s.start();
    f.start();
    //System.out.println("Exit from main");
    }
    }