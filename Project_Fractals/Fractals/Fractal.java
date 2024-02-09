
public final class Fractal{

    


    public static void main(String[] args) {

        // Mandelbrot obj = new Mandelbrot(0.5, -1, 1, -1, 1000);
        // Julia jul = new Julia(-0.5, 0.156, 1000);
        
        // MandelbrotThread obj = new MandelbrotThread());


        

        

        // jul.jul();

        Fractal obj = new Fractal();
        

        obj.executeMandelbrot();
        // jp.plotFractal("Mandebrot using Thread Set");

    }


    public void executeMandelbrot(){

        JPExtend jp = new JPExtend(800,800);

        MandelbrotThread[] obj = new MandelbrotThread[4];
        Thread[] thread = new Thread[4];

        for(int k=0;k<4;k++){

            obj[k] = new MandelbrotThread(1.0,-1.0, 1.0,-1.0, 1000,4,k);

            thread[k] =  new Thread(obj[k]);
            thread[k].start();
    
        }

        joinThreads( thread );
        
        jp.plotFractal("Mandebrot using Threads");
        }


        private void joinThread(Thread [] thread) {      //Meathod to Join Threads after they Finish
            for(int i = 0; i <4; i++){
                try {
                    thread[i].join();
                } catch (InterruptedException e) {
                    System.out.println("Thread error");
                }
            }        
        }

        private void joinThreads(Thread[] thread){

            for(Thread t : thread){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    System.out.println("Thread error");
                }
            }

        }


}
