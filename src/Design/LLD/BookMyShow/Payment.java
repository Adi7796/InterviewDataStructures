package Design.LLD.BookMyShow;

import Design.LLD.BookMyShow.Enums.PaymentMode;

import java.util.List;

public class Payment {
    int paymentId;
    PaymentMode paymentMode;
    int amount;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
