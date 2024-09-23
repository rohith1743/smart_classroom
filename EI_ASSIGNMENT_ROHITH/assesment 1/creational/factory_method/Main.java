interface Transport {
    void hire();
}


class Sedan implements Transport {
    public void hire() {
        System.out.println("Hiring a Sedan.");
    }
}


class Motorcycle implements Transport {
    public void hire() {
        System.out.println("Hiring a Motorcycle.");
    }
}


abstract class TransportFactory {
    public abstract Transport createTransport();
}


class SedanFactory extends TransportFactory {
    public Transport createTransport() {
        return new Sedan();
    }
}


class MotorcycleFactory extends TransportFactory {
    public Transport createTransport() {
        return new Motorcycle();
    }
}


public class Main {
    public static void main(String[] args) {
        TransportFactory sedanFactory = new SedanFactory();
        Transport sedan = sedanFactory.createTransport();
        sedan.hire(); // Hiring a Sedan.

        TransportFactory motorcycleFactory = new MotorcycleFactory();
        Transport motorcycle = motorcycleFactory.createTransport();
        motorcycle.hire(); // Hiring a Motorcycle.
    }
}
