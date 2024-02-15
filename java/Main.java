// Abstract class with a protected method
abstract class SuperClass {
    // Protected method declaration
    protected abstract void myMethod();
}

// Subclass that extends the abstract class and implements the protected method
class SubClass extends SuperClass {
    // Implementing the protected method
    @Override
    protected void myMethod() {
        System.out.println("Implemented method in SubClass");
    }

    // Another method that calls the protected method
    public void callMyMethod() {
        myMethod(); // Can access the protected method here
    }
}

public class Main {
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        subClass.myMethod(); // Output: Implemented method in SubClass
    }
}
