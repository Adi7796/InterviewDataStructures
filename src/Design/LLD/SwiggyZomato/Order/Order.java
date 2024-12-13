package Design.LLD.SwiggyZomato.Order;

import Design.LLD.SwiggyZomato.Customer;
import Design.LLD.SwiggyZomato.DeliveryAgent;
import Design.LLD.SwiggyZomato.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private final String orderId;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> orderItemList;
    private DeliveryAgent deliveryAgent;
    private OrderStatus orderStatus;

    public Order(String orderId, Customer customer, Restaurant restaurant) {
        this.orderId = orderId;
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderItemList = new ArrayList<>();
        this.orderStatus = OrderStatus.PENDING;
    }

    public void addItem(OrderItem orderItem) {
        orderItemList.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        orderItemList.remove(orderItem);
    }

    public void assignDeliveryAgent(DeliveryAgent deliveryAgent){
        this.deliveryAgent = deliveryAgent;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
