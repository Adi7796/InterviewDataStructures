package Design.LLD.Amazon.Users;

import Design.LLD.Amazon.Account;
import Design.LLD.Amazon.Enums.OrderStatus;
import Design.LLD.Amazon.Order.Order;
import Design.LLD.Amazon.ShoppingCart.ShoppingCart;

public class AuthenticatedUser extends Customer{

    private Account account;
    private Order order;
    @Override
    public ShoppingCart getShoppingCart() {
        return null;
    }

    public OrderStatus placeOrder(Order order){
        return OrderStatus.CONFIRMED;
    }
}
