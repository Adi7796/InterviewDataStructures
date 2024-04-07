package Design.LLD.Amazon.ShoppingCart;

import Design.LLD.Amazon.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private double totalPrice;
    private List<Product> productsList;

    public boolean addItem(Product product) { return true; }
    public boolean removeItem(Product product) { return true; }
    public List<Product> getProductsList() { return new ArrayList<>(); }
    public boolean checkout() { return true; }
}
