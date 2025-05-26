package Design.LLD.OlaUber.payment;

public class CreditCardPayment implements PaymentProcessor{

    @Override
    public void makePayment(double fare) {
        System.out.println("Processed payment using Credit Card for amount " + fare);
    }
}
