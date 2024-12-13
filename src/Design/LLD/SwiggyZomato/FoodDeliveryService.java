package Design.LLD.SwiggyZomato;

import Design.LLD.SwiggyZomato.Order.Order;
import Design.LLD.SwiggyZomato.Order.OrderItem;
import Design.LLD.SwiggyZomato.Order.OrderStatus;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {

    private static FoodDeliveryService instance;
    private final Map<String, Customer> customerMap;
    private final Map<String, Restaurant> restaurantMap;
    private final Map<String, DeliveryAgent> deliveryAgentMap;
    private final Map<String, Order> orderMap;

    private FoodDeliveryService(){
        customerMap = new ConcurrentHashMap<>();
        restaurantMap = new ConcurrentHashMap<>();
        deliveryAgentMap = new ConcurrentHashMap<>();
        orderMap = new ConcurrentHashMap<>();
    }

    public static synchronized FoodDeliveryService getInstance(){
        if(instance == null){
            instance = new FoodDeliveryService();
        }

        return instance;
    }

    public void registerCustomer(Customer customer){
        customerMap.put(customer.getCustomerId(), customer);
    }

    public void registerRestaurant(Restaurant restaurant){
        restaurantMap.put(restaurant.getRestaurantId(), restaurant);
    }

    public void registerDeliveryAgent(DeliveryAgent deliveryAgent){
        deliveryAgentMap.put(deliveryAgent.getDeliveryAgentId(), deliveryAgent);
    }

    public Order placeOrder(String customerId, String restaurantId, List<OrderItem> orderItemList){
        Customer customer = customerMap.get(customerId);
        Restaurant restaurant = restaurantMap.get(restaurantId);

        if(customer != null && restaurant != null)
        {
            Order order = new Order(generateOrderId(), customer, restaurant);
            for(OrderItem item : orderItemList){
                order.addItem(item);
            }
            orderMap.put(order.getOrderId(), order);
            notifyRestaurant(order);
            System.out.println("Order placed : " + order);
            return order;
        }
        return null;
    }

    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order = orderMap.get(orderId);
        if (order != null) {
            order.setOrderStatus(status);
            notifyCustomer(order);
            if (status == OrderStatus.CONFIRMED) {
                assignDeliveryAgent(order);
            }
        }
    }

    private void assignDeliveryAgent(Order order) {
        for (DeliveryAgent agent : deliveryAgentMap.values()) {
            if (agent.isAvailable()) {
                agent.setAvailable(false);
                order.assignDeliveryAgent(agent);
                notifyDeliveryAgent(order);
                break;
            }
        }
    }

    public void cancelOrder(String orderId) {
        Order order = orderMap.get(orderId);
        if (order != null && order.getOrderStatus() == OrderStatus.PENDING) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            notifyCustomer(order);
            notifyRestaurant(order);
            System.out.println("Order cancelled: " + order.getOrderId());
        }
    }

    public String generateOrderId(){
        return "ORD" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }

    public void notifyRestaurant(Order order){
        // Send notification to the restaurant about the new order or order status update
    }

    private void notifyCustomer(Order order) {
        // Send notification to the customer about the order status update
    }

    private void notifyDeliveryAgent(Order order) {
        // Send notification to the delivery agent about the assigned order
        // ...
    }
}
