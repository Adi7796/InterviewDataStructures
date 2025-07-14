package Design.LLD.Amazon.Order;

import Design.LLD.Amazon.Account;
import Design.LLD.Amazon.Enums.OrderStatus;
import Design.LLD.Amazon.Payment.Payment;
import Design.LLD.Amazon.Shipment.Shipment;
import Design.LLD.Amazon.ShoppingCart.ShoppingCart;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderNumber;
    private Date orderDate;
    private List<OrderLog> orderLogList;
    private ShoppingCart shoppingCart;
    private OrderStatus orderStatus;
    private Account account;
    private Shipment shipment;

    public boolean sendForShipment(){ return true; }
    public boolean makePayment(Payment payment){ return true; }
    public boolean addOrderLog(OrderLog orderLog){ return true; };
}
