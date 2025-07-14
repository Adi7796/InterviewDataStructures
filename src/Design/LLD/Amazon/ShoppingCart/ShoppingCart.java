package Design.LLD.Amazon.ShoppingCart;

import Design.LLD.Amazon.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private List<CartItem> cartItemList;

    public boolean addItem(CartItem cartItem) { return true; }
    public boolean removeItem(CartItem cartItem) { return true; }
    public List<Product> getProductsList() { return new ArrayList<>(); }
    public boolean checkout() { return true; }
}
