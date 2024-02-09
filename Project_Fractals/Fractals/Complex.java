
public class Complex {

    // x - real and y - img
    private double x;
    private double y;

    // constructor for Complex number
    public Complex(double real, double img) {
        this.x = real;
        this.y = img;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    // to get ABS(Zn)
    public static double getAbsWithSquare(Complex z){

        double abs = z.getX()*z.getX()+z.getY()*z.getY();

        return abs;
          
    }

    // to get Square(Zn)
    public static Complex getSquare(Complex z){
        double real = z.getX()*z.getX() - z.getY()*z.getY();
        double img = 2 * z.getX() * z.getY();

        return new Complex(real,img);

    }

    public static Complex square(Complex z){                    //Method get the square of a complex number
        double x =  Math.pow(z.getX(), 2) - Math.pow(z.getY(), 2);
        double y = 2*z.getX()*z.getY();
        return new Complex(x,y);
    }

    public static double absolute(Complex z){       //Method to calculate Absolute value of a complex number 
        return Math.sqrt( Math.pow(z.getX(), 2) + Math.pow(z.getY(), 2) );
    }

    // addition Square(Zn) + C
    // public static Complex addition(Complex z1, Complex z2){

    //     double real = z1.getX() + z2.getX();
    //     double img = z1.getY() + z2.getY();

    //     return new Complex(real,img);
    // }

    public static  Complex addition(Complex z1, Complex z2){    //Method to add 2 complex numbers
        double x = z1.getX() + z2.getX();
        double y = z1.getY() + z2.getY();
        return new Complex(x,y);
    }

    @Override
    public String toString() {
        return "Complex [x=" + x + ", y=" + y + "]";
    }

    
    
    
}
