// Abstract class
abstract class Abstract {
    public void vehicle() {
        System.out.println("This is a vehicle");
    }

    public abstract void car();

    public abstract void bike();
}

// Concrete subclass
class A extends Abstract {
    @Override
    public void car() {
        System.out.println("This is a car");
    }

    @Override
    public void bike() {
        System.out.println("This is a bike");
    }
}

// Main class
public class Demo1 {
    public static void main(String[] args) {
        Abstract obj = new A();
        obj.vehicle();
        obj.car();
        obj.bike();

        System.out.println("Hi");
    }
}
