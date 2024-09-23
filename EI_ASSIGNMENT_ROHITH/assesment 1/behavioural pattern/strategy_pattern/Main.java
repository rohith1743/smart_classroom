interface PaymentStrategy {
    void processPayment(double amount);
}

class CreditCard implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing payment with Credit Card for $" + amount);
    }
}

class PayPal implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing payment with PayPal for $" + amount);
    }
}

class Cryptocurrency implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing payment with Cryptocurrency for $" + amount);
    }
}

class PaymentProcessor {
    private PaymentStrategy currentPaymentMethod;

    public void choosePaymentMethod(PaymentStrategy paymentMethod) {
        this.currentPaymentMethod = paymentMethod;
    }

    public void execute(double amount) {
        if (currentPaymentMethod != null) {
            currentPaymentMethod.processPayment(amount);
        } else {
            System.out.println("No payment method selected.");
        }
    }
}

class PaymentDemo {
    public static void demoPayments() {
        PaymentProcessor processor = new PaymentProcessor();

        processor.choosePaymentMethod(new CreditCard());
        processor.execute(150.00);

        processor.choosePaymentMethod(new PayPal());
        processor.execute(200.00);

        processor.choosePaymentMethod(new Cryptocurrency());
        processor.execute(300.00);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentDemo.demoPayments();
    }
}
