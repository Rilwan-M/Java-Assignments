public class Julia extends JPExtend{


    private double cReal,cImg;
    private int iterations;
    private double RealMax = 1,RealMin = -1, ImgMax = 1,ImgMin = -1;

    public Julia(double cReal, double cImg, int iterations) {
        this.cReal = cReal;
        this.cImg = cImg;
        this.iterations = iterations;
    }
    

    public double getcReal() {
        return cReal;
    }


    public double getcImg() {
        return cImg;
    }


    public int getIterations() {
        return iterations;
    }


    public void fractalJulia(){

        double h,v;
        Complex squareZ;
        boolean divergence;
        Complex c = new Complex(this.getcReal(),this.getcImg());

        double xscale = Math.abs(this.RealMax-this.RealMin)/800.0;
        double yscale = Math.abs(this.ImgMax-this.ImgMin)/800.0;

        for(int i=0;i<800;i++){
            
            for(int j=0;j<800;j++){
                h = -1 + i*xscale;   // horizontal scale  
                v = 1 - j*yscale;  // vertical scale

                Complex z = new Complex(h, v);

                divergence = false;

                for(int iter=0;iter<this.getIterations();iter++){

                    squareZ = Complex.square(z);
                    z = Complex.addition(c, squareZ);

                    if(Complex.absolute(z) > 4){
                        
                        // plotNotInSet( i, j, iter );        //Not in Julia set
                        System.out.println("not set ");
                        divergence = true;
                        break;
                    }

                }

                if(divergence == false){

                    // plotInSet( i, j );  // in Julia Set
                    System.out.println("set ");
                }



            }
        }
    }


    public void jul(){
        double real;                //Cordinates in complex plane
        double complex;
        boolean divergeState;
        Complex znew;
        double unitScale = 2.0/800; 
                   //Common Unit Scale for real and complex
        
        for (int j=0; j<800; j++){      //Looping through Vertical axis of panel
            for(int i=0; i<800; i++){           //Looping through Horizontal  axis of panel
                
                real = -1 + unitScale*i;                //Real part in complex plane
                complex = 1 - unitScale*j; 

                // System.out.println("x Scale is "+real +" Y scale "+ complex);
                
                //Complex part in complex plane
                Complex z = new Complex(real,complex);
                Complex c = new Complex(this.getcReal(),this.getcImg());  // julia constant
                divergeState = false;

                for (int s=0; s < this.getIterations(); s++){     //Count of number of iteration
                    znew = Complex.square(z);           //Square of Zn
                    z = Complex.addition(c , znew );  // Zn^2 + JuliaConstant
                    
                    if(Complex.absolute(z)>4){          //Check for julia set number
                        plotNotInSet( i, j, s );        //Not in Julia set
                        // System.out.println("not set ");
                        divergeState = true;
                        break;
                    }
                }
                
                if( divergeState == false ){          //In Julia set
                    plotInSet( i, j );
                    // System.out.println("set ");
                }
            }
        }
    }
    
}
