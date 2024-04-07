package Design.LLD.Amazon.Shipment;

import java.util.Date;
import java.util.List;

public class Shipment {
    private String shipmentNumber;
    private Date shipmentDate;
    private Date estimatedDeliveryDate;
    private String shipmentMethod;
    private List<ShipmentLog> shipmentLogList;

    public boolean addShipmentLog(ShipmentLog shipmentLog) { return true ;}
}
