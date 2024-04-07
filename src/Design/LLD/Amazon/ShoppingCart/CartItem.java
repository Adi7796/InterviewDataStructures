package Design.LLD.Amazon.ShoppingCart;

public class CartItem {
    private double price;
    private int quantity;

    public boolean updateQuantity(int newQuantity) {
        quantity =+ newQuantity;
        return true;
    }
}
