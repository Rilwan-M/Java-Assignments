
// SAM
interface Function<T>{


    void print(T item);


}

public class HigherOrderFunction {

    static void PassFunctionAsArgument(Function<String> obj,String x){obj.print(x); }

// implementation of Function.print in anoter name.. thats all
    static void display(String item){ System.out.println(item);}


    public static void main(String[] args) {

        HigherOrderFunction.PassFunctionAsArgument(HigherOrderFunction::display,"Hello");

        
    }


   

    
}
