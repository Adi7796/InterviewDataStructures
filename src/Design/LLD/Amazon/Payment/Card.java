package Design.LLD.Amazon.Payment;

import Design.LLD.Amazon.Enums.PaymentStatus;

public class Card extends Payment{

    private String nameOnCard;
    private String cardNumber;
    private String expiryDate;
    private String cvv;
    @Override
    public PaymentStatus makePayment() {
        return PaymentStatus.SUCCESSFUL;
    }
}
