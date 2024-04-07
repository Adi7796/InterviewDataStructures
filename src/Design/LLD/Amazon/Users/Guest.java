package Design.LLD.Amazon.Users;

import Design.LLD.Amazon.ShoppingCart.ShoppingCart;

public class Guest extends Customer{
    @Override
    public ShoppingCart getShoppingCart() {
        return null;
    }

    public boolean registerAccount(){ return true; }
}
