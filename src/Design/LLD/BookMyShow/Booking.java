package Design.LLD.BookMyShow;

import java.util.List;

public class Booking {

    private Show show;
    private List<Seat> selectedSeatsList;
    private Payment payment;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSelectedSeatsList() {
        return selectedSeatsList;
    }

    public void setSelectedSeatsList(List<Seat> selectedSeatsList) {
        this.selectedSeatsList = selectedSeatsList;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
