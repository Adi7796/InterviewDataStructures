package Design.LLD.Amazon.Payment;

import Design.LLD.Amazon.Enums.PaymentStatus;

import java.util.Date;

public abstract class Payment {

    PaymentStatus paymentStatus;
    private double amount;
    private Date timeStamp;

    public abstract PaymentStatus makePayment();
}
