public class MandelbrotThread extends JPExtend implements Runnable{


    private double RealMax,RealMin,ImgMax,ImgMin;
    private int Iterations,NoOfThreads,ThreadNo,heightStart, heightEnd;
    private final int HEIGHT = 800, WIDTH = 800;


    public double getRealMax() {
        return RealMax;
    }

    public double getRealMin() {
        return RealMin;
    }

    public double getImgMax() {
        return ImgMax;
    }

    public double getImgMin() {
        return ImgMin;
    }

    public double getIterations() {
        return Iterations;
    }



    public MandelbrotThread(double realMax, double realMin, double imgMax, double imgMin, int iterations, int noOfThreads, int ThreadNo) {
        super();
        this.RealMax = realMax;
        this.RealMin = realMin;
        this.ImgMax = imgMax;
        this.ImgMin = imgMin;
        this.Iterations = iterations;
        this.NoOfThreads = noOfThreads;
        this.ThreadNo = ThreadNo;

        this.heightStart = (HEIGHT/NoOfThreads)* ThreadNo;    //Calculating points range to process in a single Thread
        this.heightEnd = (HEIGHT/NoOfThreads)*(ThreadNo+1);
    }


    // public void executeMandelbrot(){

    //     MandelbrotThread[] obj = new MandelbrotThread[NoOfThreads];
    //     Thread[] thread = new Thread[NoOfThreads];

    //     for(int k=0;k<NoOfThreads;k++){

    //         obj[k] = new MandelbrotThread(1.0,-1.0, 1.0,-1.0, 1000,4,k+1);

    //         thread[k] =  new Thread(obj[k]);
    //         thread[k].start();
    
    //     }

    //     joinThreads( thread );
        
    //     plotFractal("Mandebrot using Threads");
    //     }



    


    public int getNoOfThreads() {
        return NoOfThreads;
    }

    public void run(){


        double xscale = Math.abs(this.getRealMax() - this.getRealMin())/800.0;
        double yscale = Math.abs(this.getImgMax() - this.getImgMin())/800.0;
        boolean divergence;

        for(int j=heightStart;j<heightEnd;j++){

            
            for (int i=0;i<800;i++){

                double h = this.getRealMin()+i*xscale;   // horizontal axis point
                
                double v = this.getImgMax() - j*yscale; // vertical axis point
                Complex c = new Complex(h,v);       // mapped point in real-img scale
                Complex z = new Complex(0,0);       // initial complex point
                divergence = false;

                for(int iter=0;iter<this.getIterations();iter++){

                    Complex squareZ = Complex.getSquare(z);
                    z = Complex.addition(squareZ, c);

                    if(Complex.absolute(z) > 4){

                        // convergence = false;
                        divergence = true;
                        plotNotInSet( i, j, iter );        //Not in Mandelbrot set
                        // System.out.println("This is not MandelBrot");
                        break;



                    }

        
                }

                if(divergence ==  false){

                    // System.out.println("This is MandelBrot");
                    plotInSet( i, j );
                }


            }
        }
    }

}
