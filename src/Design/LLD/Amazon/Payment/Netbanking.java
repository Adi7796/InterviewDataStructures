package Design.LLD.Amazon.Payment;

import Design.LLD.Amazon.Enums.PaymentStatus;

public class Netbanking extends Payment{

    private String bankName;
    private String accountNumber;
    private String accountName;
    @Override
    public PaymentStatus makePayment() {
        return PaymentStatus.PENDING;
    }
}
