package Design.LLD.CarRentalSystem.Service;

public class Bill {

    private Reservation reservation;
    private boolean isBillPaid;
    private double billAmount;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.billAmount = getBillAmount();
        this.isBillPaid = false;
    }

    private Double getBillAmount() {
        return 100.0;
    }
}
