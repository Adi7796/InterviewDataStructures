package Design.LLD.Amazon.Payment;

import Design.LLD.Amazon.Enums.PaymentStatus;

public class Cash extends Payment{

    private String billingAddress;
    @Override
    public PaymentStatus makePayment() {
        return PaymentStatus.SUCCESSFUL;
    }
}
