package Design.LLD.OlaUber.payment;

public class UPIPayment implements PaymentProcessor{

    @Override
    public void makePayment(double fare) {
        System.out.println("Processed payment using UPI for amount " + fare);
    }
}
