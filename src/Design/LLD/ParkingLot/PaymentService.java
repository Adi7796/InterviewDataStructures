package Design.LLD.ParkingLot;

import Design.LLD.ParkingLot.Model.Ticket;

public interface PaymentService {
    double scanAndPay(Ticket ticket);
}
