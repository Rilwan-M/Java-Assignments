// This example shows how lambda expression takes functiosn as arguement
// this will be useful for collections in java

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;    // functional interface returns a bollean 



// single functional interface for print
interface Test<T>{

    void print(List<T> array);      
}


// Single Abstract Method (SAM) is for retunring generci type 
interface TestArray<T>{

    T copyToAnotherArray(T item);
}



public class BehaviorExample {



    public static void main(String[] args) {

        List<String> array = new ArrayList<>();

        array.add("A");
        array.add("A");
        array.add("A");
        array.add("A");
        array.add("B");
        array.add("B");
        array.add("B");
        array.add("A");


        // printUsingGenerics(array);

        // print using lambda function

        // Test<String> display = (List<String> arr)->{   for(String item : arr) System.out.println(item);};

        // display.print(array);

        // TestArray<String> ch = (a)-> a;

        // System.out.println(ch.copyToAnotherArray("Rilwan"));

        Test<String> obj = (List<String> arr)->{ print(arr);};

        obj.print(array);





        
    }

//mwthod for print

public static void print(List<String> array){
    for(String item: array)
        System.out.println(item);
}

// method for print uisng generics
public static <T> void printUsingGenerics(List<T> array){

    for(T item : array)
        System.out.println(item);
}



    
}
