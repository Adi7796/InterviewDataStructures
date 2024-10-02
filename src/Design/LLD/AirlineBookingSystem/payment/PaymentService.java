package Design.LLD.AirlineBookingSystem.payment;

public class PaymentService {

    private final String paymentId;
    private final String paymentMethod;
    private final double price;
    private PaymentStatus paymentStatus;

    public PaymentService(String paymentId, String paymentMethod, double price) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void processPayment()
    {
        // logic to process payment
        paymentStatus = PaymentStatus.SUCCESSFUL;
    }
}
